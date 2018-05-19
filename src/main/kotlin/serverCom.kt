package frontEnd

import addMarker
import google.maps.*
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.html.js.div
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.xhr.XMLHttpRequest
import kotlin.browser.document

fun login(mail: String, pass : String, map: Map)
{
    val req = XMLHttpRequest()

    req.open("GET", "http://localhost:8080/rest/management/login?mail=$mail&pass=$pass", false)

    req.send()

    while(req.readyState != XMLHttpRequest.DONE){}

    if ( req.status == 200.toShort())
    {
        val array = JSON.parse<Array<PointOfInterest>>(req.responseText)

        for (elem : PointOfInterest in array)
        {
            addMarker(LatLng(elem.lat, elem.lon), elem.name, elem.description, map)
        }
    }

    var admin = document.getElementById("admin")

    val console = document.create.div {
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

    admin!!.appendChild(console)
}

fun addNewPlace(event: MouseEvent, map: Map, mail: String, pass: String)
{
    var admin = document.getElementById("admin")
    admin!!.firstElementChild!!.remove()
    var pos : LatLng = event.latLng

    val addPlace = document.create.div {
        id = "addPlace"
        h2 {
            +pos.toString()
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
            id = "Add Place"
            type = InputType.submit
            onClickFunction = {
                if (document.getElementById("name")!=null && document.getElementById("description")!=null)
                {
                    val name = document.getElementById("name") as HTMLInputElement
                    val description = document.getElementById("description") as HTMLInputElement
                    val req = XMLHttpRequest()
                    req.open("POST", "http://localhost:8080/rest/management/newPlace?mail=$mail&pass=$pass", false)
                    req.setRequestHeader("Content-Type", "application/json")
                    req.send(JSON.stringify(PointOfInterest(event.latLng.lat().toDouble(),
                                             event.latLng.lng().toDouble(),
                                             name.value,
                                             description.value,
                                             "download.jpg")))

                    while(req.readyState != XMLHttpRequest.DONE){}

                    if ( req.status == 201.toShort())
                    {
                        val poi = JSON.parse<PointOfInterest>(req.responseText)

                        addMarker(LatLng(poi.lat, poi.lon), poi.name, poi.description, map)
                    }

                    admin!!.firstElementChild!!.remove()
                    google.maps.event.clearListeners(map, "click")

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