package frontEnd

import google.maps.LatLng
import google.maps.MapOptions
import kotlinx.html.dom.create
import kotlinx.html.h1
import kotlinx.html.h2
import kotlinx.html.id
import kotlinx.html.js.div
import kotlinx.html.script
import org.w3c.dom.HTMLElement
import org.w3c.xhr.XMLHttpRequest
import kotlin.browser.document
import google.maps.*

fun login(mail: String?, pass : String?)
{
    val req = XMLHttpRequest()

    req.open("GET", "http://localhost:8080/rest/management/login?mail=$mail&pass=$pass", false)

    req.send()

    while(req.readyState != XMLHttpRequest.DONE){}

    if ( req.status == 200.toShort())
    {
        val array = JSON.parse<Array<PointOfInterest>>(req.responseText)

        val map = document.getElementById("map")

        for (elem : PointOfInterest in array)
        {
            addMarker(LatLng(elem.lat, elem.lon), elem.name, elem.description)

            console.log(elem.name)
        }
    }
}

external fun addMarker(loc : LatLng, name: String, desc: String): Nothing