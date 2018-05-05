@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsQualifier("google.maps.geometry")
package google.maps.geometry

import kotlin.js.*
import google.maps.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

external open class encoding {
    companion object {
        fun decodePath(encodedPath: String): Array<LatLng> = definedExternally
        fun encodePath(path: Array<LatLng>): String = definedExternally
        fun encodePath(path: MVCArray<LatLng>): String = definedExternally
    }
}
external open class spherical {
    companion object {
        fun computeArea(path: Array<LatLng>, radius: Number? = definedExternally /* null */): Number = definedExternally
        fun computeArea(path: MVCArray<LatLng>, radius: Number? = definedExternally /* null */): Number = definedExternally
        fun computeDistanceBetween(from: LatLng, to: LatLng, radius: Number? = definedExternally /* null */): Number = definedExternally
        fun computeHeading(from: LatLng, to: LatLng): Number = definedExternally
        fun computeLength(path: Array<LatLng>, radius: Number? = definedExternally /* null */): Number = definedExternally
        fun computeLength(path: MVCArray<LatLng>, radius: Number? = definedExternally /* null */): Number = definedExternally
        fun computeOffset(from: LatLng, distance: Number, heading: Number, radius: Number? = definedExternally /* null */): LatLng = definedExternally
        fun computeOffsetOrigin(to: LatLng, distance: Number, heading: Number, radius: Number? = definedExternally /* null */): LatLng = definedExternally
        fun computeSignedArea(loop: Array<LatLng>, radius: Number? = definedExternally /* null */): Number = definedExternally
        fun computeSignedArea(loop: MVCArray<LatLng>, radius: Number? = definedExternally /* null */): Number = definedExternally
        fun interpolate(from: LatLng, to: LatLng, fraction: Number): LatLng = definedExternally
    }
}
external open class poly {
    companion object {
        fun containsLocation(point: LatLng, polygon: Polygon): Boolean = definedExternally
        fun isLocationOnEdge(point: LatLng, poly: Polygon, tolerance: Number? = definedExternally /* null */): Boolean = definedExternally
        fun isLocationOnEdge(point: LatLng, poly: Polyline, tolerance: Number? = definedExternally /* null */): Boolean = definedExternally
    }
}
