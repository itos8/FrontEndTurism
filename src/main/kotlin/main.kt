import frontEnd.Position
import kotlinx.html.*
import frontEnd.login
import google.maps.LatLng
import google.maps.Map
import google.maps.PolygonOptions
import kotlinx.html.dom.create
import kotlin.browser.document
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import kotlin.js.Console

fun main(args: Array<String>)
{
    val root = document.getElementById("root")

    val home = document.create.div{
        id = "home"

        val map = google.maps.Map(document.getElementById("map"))
        map.setCenter(latlng = LatLng(45, 7))
        map.setZoom(2)

        h1{
            +"HOME"
        }

        br
        input {
            id = "mail"
            type = InputType.text
        }
        br
        input {
            id = "pass"
            type = InputType.text
        }
        br
        input{
            value = "Login"
            type = InputType.submit
            onClickFunction = { val mail = document.getElementById("mail") as HTMLInputElement
                val pass = document.getElementById("pass") as HTMLInputElement
                val login = login(mail.value,
                                        pass.value,
                                        map)

                root!!.firstElementChild!!.remove()
            }
        }
    }

    root!!.appendChild(home)
}

fun addMarker(latLng: LatLng, name: String, description: String, map: Map)
{
    var contentString =
            "<div id=\"content\">"+
                    "<div id=\"siteNotice>"+
                    "</div>"+
                    "<h2 id=\"firstHeading\" class=\"firstHeading\">$name</h2>"+
                    "<div id=\"bodyContent\">$description</div>"+
                    "</div>"

    var infoWindow = google.maps.InfoWindow()
    infoWindow.setContent(contentString)

    var marker = google.maps.Marker()
    marker.setPosition(latLng)
    marker.setMap(map)

    marker.addListener("click", { infoWindow.open(map, marker) })
}

fun addPolygon(polygon: Array<Position>, map: Map)
{
    var path = mutableListOf<LatLng>()

    for (elem : Position in polygon)
        path.add(LatLng(elem.lat, elem.lon))

    var polygon = google.maps.Polygon()
    polygon.setDraggable(false)
    polygon.setEditable(false)
    polygon.setPath(path.toTypedArray())
    polygon.set("strokeWeight", 1)
    polygon.set("strokeColor", "#0000FF")
    polygon.set("fillColor", "#0000FF")
    polygon.set("fillOpacity", 0.35)
    polygon.setMap(map)
}