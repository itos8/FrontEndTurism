@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsQualifier("google.maps.drawing")
package google.maps.drawing

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

external open class DrawingManager(options: DrawingManagerOptions? = definedExternally /* null */) : MVCObject {
    open fun getDrawingMode(): OverlayType = definedExternally
    open fun getMap(): Map = definedExternally
    open fun setDrawingMode(drawingMode: OverlayType?): Unit = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
    open fun setOptions(options: DrawingManagerOptions): Unit = definedExternally
}
external interface DrawingManagerOptions {
    var circleOptions: CircleOptions? get() = definedExternally; set(value) = definedExternally
    var drawingControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var drawingControlOptions: DrawingControlOptions? get() = definedExternally; set(value) = definedExternally
    var drawingMode: OverlayType? get() = definedExternally; set(value) = definedExternally
    var map: Map? get() = definedExternally; set(value) = definedExternally
    var markerOptions: MarkerOptions? get() = definedExternally; set(value) = definedExternally
    var polygonOptions: PolygonOptions? get() = definedExternally; set(value) = definedExternally
    var polylineOptions: PolylineOptions? get() = definedExternally; set(value) = definedExternally
    var rectangleOptions: RectangleOptions? get() = definedExternally; set(value) = definedExternally
}
external interface DrawingControlOptions {
    var drawingModes: Array<OverlayType>? get() = definedExternally; set(value) = definedExternally
    var position: ControlPosition? get() = definedExternally; set(value) = definedExternally
}
external interface OverlayCompleteEvent {
    var overlay: dynamic /* Marker | Polygon | Polyline | Rectangle | Circle */
    var type: OverlayType
}
external enum class OverlayType {
    CIRCLE,
    MARKER,
    POLYGON,
    POLYLINE,
    RECTANGLE
}
