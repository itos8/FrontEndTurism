package frontEnd

import addMarker
import addPolygon
import google.maps.*
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.html.js.div
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.get
import org.w3c.files.Blob
import org.w3c.files.File
import org.w3c.files.FileReader
import org.w3c.files.get
import org.w3c.xhr.XMLHttpRequest
import kotlin.browser.document

fun login(mail: String, pass : String, map: Map)
{
    val req = XMLHttpRequest()

    req.open("GET", "http://localhost:8080/rest/management/login?mail=$mail&pass=$pass", false)

    req.send()

    var admin = document.getElementById("admin")
    var console : HTMLElement

    while(req.readyState != XMLHttpRequest.DONE){}

    if ( req.status == 200.toShort())
    {
        val array = JSON.parse<Array<Point>>(req.responseText)

        if (array.size>0)
        {
            map.setCenter(LatLng(array[0].position.lat, array[0].position.lon))
            map.setZoom(10)
        }

        for (elem : Point in array)
        {
            addMarker(LatLng(elem.position.lat, elem.position.lon), elem.name, elem.description, map)

            addPolygon(elem.polygon, map, false)
        }


        console = document.create.div {
            input {
                value = "New place"
                type = InputType.submit
                onClickFunction = {
                    admin!!.firstElementChild!!.remove()
                    admin!!.appendChild(document.create.div { h2 { +"Click on map to choise the point"} })
                    event.addListener(map, "click", {event: MouseEvent -> addNewPlace(event, map, mail, pass) })
                }
            }
        }
    }
    else
    {
        console = document.create.div {
            h2 {
                +"Problemi di autenticazione"
            }
        }
    }

    admin!!.appendChild(console)
}

fun addNewPlace(event: MouseEvent, map: Map, mail: String, pass: String)
{
    google.maps.event.clearListeners(map, "click")

    var admin = document.getElementById("admin")
    admin!!.firstElementChild!!.remove()
    var pos : LatLng = event.latLng
    val marker = addMarker(event.latLng,"", "", map)
    var positions = arrayOf<Position>( Position(pos.lat().toDouble()+0.001,pos.lng().toDouble()+0.001),
                                                     Position(pos.lat().toDouble()+0.001,pos.lng().toDouble()-0.001),
                                                     Position(pos.lat().toDouble()-0.001,pos.lng().toDouble()-0.001),
                                                     Position(pos.lat().toDouble()-0.001,pos.lng().toDouble()+0.001),
                                                     Position(pos.lat().toDouble()+0.001,pos.lng().toDouble()+0.001)
            )
    val polygon = addPolygon(positions, map, true)
    polygon.addListener("mousemove", {var money = document.getElementById("Money")
                                              money!!.textContent = (google.maps.geometry.spherical.computeArea(polygon.getPath()).toInt()/1000).toString() + " €"})

    val addPlace = document.create.div {
        id = "addPlace"
        h2 {
            +pos.toString()
        }
        h2 {
            id = "Money"
            +(google.maps.geometry.spherical.computeArea(polygon.getPath()).toInt()/1000).toString()
            +" €"
        }
        input {
            id = "name"
            type = InputType.text
        }
        br
        input {
            id = "description"
            type = InputType.text
        }
        br
        input {
            id = "image"
            type = InputType.file
        }
        br
        input {
            id = "Add Place"
            type = InputType.submit
            onClickFunction = {
                if (document.getElementById("name")!=null && document.getElementById("description")!=null)
                {
                    val name = document.getElementById("name") as HTMLInputElement
                    val description = document.getElementById("description") as HTMLInputElement
                    val nameImage = document.getElementById("image") as HTMLInputElement
                    val req = XMLHttpRequest()

                    val listPoint = arrayOf<Position>()
                    var i = 0

                    for (elem in polygon.getPath().getArray())
                    {
                        if (i == 0)
                            listPoint[polygon.getPath().getLength().toInt()] = Position(elem.lat().toDouble(), elem.lng().toDouble())
                        listPoint[i] = Position(elem.lat().toDouble(), elem.lng().toDouble())
                        i++
                    }

                    polygon.setMap(null)
                    req.open("POST", "http://localhost:8080/rest/management/newPlace?mail=$mail&pass=$pass", false)
                    req.setRequestHeader("Content-Type", "application/json")
                    req.send(JSON.stringify(Point(Position(pos.lat().toDouble(), pos.lng().toDouble()),
                                             name.value,
                                             description.value,
                                             listPoint,
                                             nameImage.value)))

                    while(req.readyState != XMLHttpRequest.DONE){}

                    if ( req.status == 201.toShort())
                    {
                        /*var req2 = XMLHttpRequest()
                        req2.open("POST", "http://localhost:8080/rest/management/newImage?mail=$mail&pass=$pass&nameImage=${nameImage.value}", false)
                        req2.setRequestHeader("Content-Type", "image/jpeg")

                        req2.send(nameImage.files!![0])

                        while(req2.readyState != XMLHttpRequest.DONE){}

                        if ( req2.status == 201.toShort())
                        {*/
                            val poi = JSON.parse<Point>(req.responseText)

                            addMarker(LatLng(poi.position.lat, poi.position.lon), poi.name, poi.description, map)

                            addPolygon(poi.polygon, map, false)
                        //}

                    }

                    admin!!.firstElementChild!!.remove()

                    val console = document.create.div {
                        input {
                            value = "New place"
                            type = InputType.submit
                            onClickFunction = {
                                admin!!.firstElementChild!!.remove()
                                admin!!.appendChild(document.create.textArea { "Click on map to choise the point" })
                                google.maps.event.addListener(map, "click", { event: MouseEvent -> addNewPlace(event, map, mail, pass) })
                            }
                        }
                    }

                    admin!!.appendChild(console)
                }
            }
        }
    }

    admin!!.appendChild(addPlace)
}