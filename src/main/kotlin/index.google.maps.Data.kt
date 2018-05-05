@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsQualifier("google.maps.Data")
package google.maps.Data

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

external interface DataOptions {
    var controlPosition: ControlPosition? get() = definedExternally; set(value) = definedExternally
    //var controls: Array<DrawingMode>? get() = definedExternally; set(value) = definedExternally
    //var drawingMode: DrawingMode? get() = definedExternally; set(value) = definedExternally
    var featureFactory: ((geometry: Geometry) -> Feature)? get() = definedExternally; set(value) = definedExternally
    var map: Map? get() = definedExternally; set(value) = definedExternally
    var style: dynamic /* Data.StylingFunction | Data.StyleOptions */ get() = definedExternally; set(value) = definedExternally
}
external interface GeoJsonOptions {
    var idPropertyName: String? get() = definedExternally; set(value) = definedExternally
}
external interface StyleOptions {
    var clickable: Boolean? get() = definedExternally; set(value) = definedExternally
    var cursor: String? get() = definedExternally; set(value) = definedExternally
    var draggable: Boolean? get() = definedExternally; set(value) = definedExternally
    var editable: Boolean? get() = definedExternally; set(value) = definedExternally
    var fillColor: String? get() = definedExternally; set(value) = definedExternally
    var fillOpacity: Number? get() = definedExternally; set(value) = definedExternally
    var icon: dynamic /* String | Icon | Symbol */ get() = definedExternally; set(value) = definedExternally
    var shape: MarkerShape? get() = definedExternally; set(value) = definedExternally
    var strokeColor: String? get() = definedExternally; set(value) = definedExternally
    var strokeOpacity: Number? get() = definedExternally; set(value) = definedExternally
    var strokeWeight: Number? get() = definedExternally; set(value) = definedExternally
    var title: String? get() = definedExternally; set(value) = definedExternally
    var visible: Boolean? get() = definedExternally; set(value) = definedExternally
    var zIndex: Number? get() = definedExternally; set(value) = definedExternally
}
external open class Feature(options: FeatureOptions? = definedExternally /* null */) {
    open fun forEachProperty(callback: (value: Any, name: String) -> Unit): Unit = definedExternally
    open fun getGeometry(): Geometry = definedExternally
    open fun getId(): dynamic /* Number | String */ = definedExternally
    open fun getProperty(name: String): Any = definedExternally
    open fun removeProperty(name: String): Unit = definedExternally
    open fun setGeometry(newGeometry: Geometry): Unit = definedExternally
    open fun setGeometry(newGeometry: LatLng): Unit = definedExternally
    //open fun setGeometry(newGeometry: LatLngLiteral): Unit = definedExternally
    open fun setProperty(name: String, newValue: Any): Unit = definedExternally
    open fun toGeoJson(callback: (feature: Any) -> Unit): Unit = definedExternally
}
external interface FeatureOptions {
    var geometry: dynamic /* Data.Geometry | LatLng | LatLngLiteral */ get() = definedExternally; set(value) = definedExternally
    var id: dynamic /* Number | String */ get() = definedExternally; set(value) = definedExternally
    var properties: Any? get() = definedExternally; set(value) = definedExternally
}
external open class Geometry {
    open fun getType(): String = definedExternally
    open fun forEachLatLng(callback: (latLng: LatLng) -> Unit): Unit = definedExternally
}
external open class Point : Geometry {
    constructor(latLng: LatLng)
    //constructor(latLng: LatLngLiteral)
    open fun get(): LatLng = definedExternally
}
external open class MultiPoint(elements: Array<dynamic /* LatLng | LatLngLiteral */>) : Geometry {
    open fun getArray(): Array<LatLng> = definedExternally
    open fun getAt(n: Number): LatLng = definedExternally
    open fun getLength(): Number = definedExternally
}
external open class LineString(elements: Array<dynamic /* LatLng | LatLngLiteral */>) : Geometry {
    open fun getArray(): Array<LatLng> = definedExternally
    open fun getAt(n: Number): LatLng = definedExternally
    open fun getLength(): Number = definedExternally
}
external open class MultiLineString(elements: Array<dynamic /* Data.LineString | Array<dynamic /* LatLng | LatLngLiteral */> */>) : Geometry {
    open fun getArray(): Array<LineString> = definedExternally
    open fun getAt(n: Number): LineString = definedExternally
    open fun getLength(): Number = definedExternally
}
external open class LinearRing(elements: Array<dynamic /* LatLng | LatLngLiteral */>) : Geometry {
    open fun getArray(): Array<LatLng> = definedExternally
    open fun getAt(n: Number): LatLng = definedExternally
    open fun getLength(): Number = definedExternally
}
external open class Polygon(elements: Array<dynamic /* Data.LinearRing | Array<dynamic /* LatLng | LatLngLiteral */> */>) : Geometry {
    open fun getArray(): Array<LinearRing> = definedExternally
    open fun getAt(n: Number): LinearRing = definedExternally
    open fun getLength(): Number = definedExternally
}
external open class MultiPolygon(elements: Array<dynamic /* Data.Polygon | Array<dynamic /* LinearRing | Array<dynamic /* LatLng | LatLngLiteral */> */> */>) : Geometry {
    open fun getArray(): Array<Polygon> = definedExternally
    open fun getAt(n: Number): Polygon = definedExternally
    open fun getLength(): Number = definedExternally
}
external open class GeometryCollection(elements: Array<dynamic /* Array<Data.Geometry> | Array<LatLng> | LatLngLiteral */>) : Geometry {
    open fun getArray(): Array<Geometry> = definedExternally
    open fun getAt(n: Number): Geometry = definedExternally
    open fun getLength(): Number = definedExternally
}
external interface MouseEvent : google.maps.MouseEvent {
    var feature: Feature
}
external interface AddFeatureEvent {
    var feature: Feature
}
external interface RemoveFeatureEvent {
    var feature: Feature
}
external interface SetGeometryEvent {
    var feature: Feature
    var newGeometry: Geometry
    var oldGeometry: Geometry
}
external interface SetPropertyEvent {
    var feature: Feature
    var name: String
    var newValue: Any
    var oldValue: Any
}
external interface RemovePropertyEvent {
    var feature: Feature
    var name: String
    var oldValue: Any
}
