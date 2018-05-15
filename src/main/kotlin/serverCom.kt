package frontEnd

import addMarker
import google.maps.*
import kotlinx.html.InputType
import kotlinx.html.dom.create
import kotlinx.html.input
import kotlinx.html.js.div
import kotlinx.html.js.onClickFunction
import org.w3c.xhr.XMLHttpRequest
import kotlin.browser.document

fun login(mail: String?, pass : String?, map: Map)
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
                event.addListener(map, "click", {event: MouseEvent -> addLatLng(event, map)})
            }
        }
    }

    admin!!.appendChild(console)
}

fun addLatLng(event: MouseEvent, map: Map)
{
   addMarker(event.latLng, "Nome", "ciao", map)
}

//external fun addMarker(loc : LatLng, name: String, desc: String): Nothing