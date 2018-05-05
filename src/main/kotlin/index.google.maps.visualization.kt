@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsQualifier("google.maps.visualization")
package google.maps.visualization

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

external open class MapsEngineLayer(options: MapsEngineLayerOptions) : MVCObject {
    open fun getLayerId(): String = definedExternally
    open fun getLayerKey(): String = definedExternally
    open fun getMap(): Map = definedExternally
    open fun getMapId(): String = definedExternally
    open fun getOpacity(): Number = definedExternally
    open fun getProperties(): MapsEngineLayerProperties = definedExternally
    open fun getStatus(): MapsEngineStatus = definedExternally
    open fun getZIndex(): Number = definedExternally
    open fun setLayerId(layerId: String): Unit = definedExternally
    open fun setLayerKey(layerKey: String): Unit = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
    open fun setMapId(mapId: String): Unit = definedExternally
    open fun setOpacity(opacity: Number): Unit = definedExternally
    open fun setOptions(options: MapsEngineLayerOptions): Unit = definedExternally
    open fun setZIndex(zIndex: Number): Unit = definedExternally
}
external interface MapsEngineLayerOptions {
    var accessToken: String? get() = definedExternally; set(value) = definedExternally
    var clickable: Boolean? get() = definedExternally; set(value) = definedExternally
    var fitBounds: Boolean? get() = definedExternally; set(value) = definedExternally
    var layerId: String? get() = definedExternally; set(value) = definedExternally
    var layerKey: String? get() = definedExternally; set(value) = definedExternally
    var map: Map? get() = definedExternally; set(value) = definedExternally
    var mapId: String? get() = definedExternally; set(value) = definedExternally
    var opacity: Number? get() = definedExternally; set(value) = definedExternally
    var suppressInfoWindows: Boolean? get() = definedExternally; set(value) = definedExternally
    var zIndex: Number? get() = definedExternally; set(value) = definedExternally
}
external interface MapsEngineLayerProperties {
    var name: String
}
external interface MapsEngineMouseEvent {
    var featureId: String? get() = definedExternally; set(value) = definedExternally
    var infoWindowHtml: String? get() = definedExternally; set(value) = definedExternally
    var latLng: LatLng? get() = definedExternally; set(value) = definedExternally
    var pixelOffset: Size? get() = definedExternally; set(value) = definedExternally
}
external enum class MapsEngineStatus {
    INVALID_LAYER,
    OK,
    UNKNOWN_ERROR
}
external open class HeatmapLayer(opts: HeatmapLayerOptions? = definedExternally /* null */) : MVCObject {
    open fun <T> getData(): MVCArray<T> = definedExternally
    open fun getMap(): Map = definedExternally
    open fun setData(data: MVCArray<dynamic /* LatLng | WeightedLocation */>): Unit = definedExternally
    open fun setData(data: Array<LatLng>): Unit = definedExternally
    open fun setData(data: Array<WeightedLocation>): Unit = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
}
external interface HeatmapLayerOptions {
    var data: Any
    var dissipating: Boolean? get() = definedExternally; set(value) = definedExternally
    var gradient: Array<String>? get() = definedExternally; set(value) = definedExternally
    var map: Map? get() = definedExternally; set(value) = definedExternally
    var maxIntensity: Number? get() = definedExternally; set(value) = definedExternally
    var opacity: Number? get() = definedExternally; set(value) = definedExternally
    var radius: Number? get() = definedExternally; set(value) = definedExternally
}
external interface WeightedLocation {
    var location: LatLng
    var weight: Number
}
external open class MouseEvent {
    open fun stop(): Unit = definedExternally
}
external open class MapsEventListener
