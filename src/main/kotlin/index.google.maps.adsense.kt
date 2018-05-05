@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsQualifier("google.maps.adsense")
package google.maps.adsense

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

external open class AdUnit(container: Element, opts: AdUnitOptions) : MVCObject {
    open fun getBackgroundColor(): String = definedExternally
    open fun getBorderColor(): String = definedExternally
    open fun getChannelNumber(): String = definedExternally
    open fun getContainer(): Element = definedExternally
    open fun getFormat(): AdFormat = definedExternally
    open fun getMap(): Map = definedExternally
    open fun getPosition(): ControlPosition = definedExternally
    open fun getPublisherId(): String = definedExternally
    open fun getTextColor(): String = definedExternally
    open fun getTitleColor(): String = definedExternally
    open fun getUrlColor(): String = definedExternally
    open fun setBackgroundColor(backgroundColor: String): Unit = definedExternally
    open fun setBorderColor(borderColor: String): Unit = definedExternally
    open fun setChannelNumber(channelNumber: String): Unit = definedExternally
    open fun setFormat(format: AdFormat): Unit = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
    open fun setPosition(position: ControlPosition): Unit = definedExternally
    open fun setTextColor(textColor: String): Unit = definedExternally
    open fun setTitleColor(titleColor: String): Unit = definedExternally
    open fun setUrlColor(urlColor: String): Unit = definedExternally
}
external interface AdUnitOptions {
    var backgroundColor: String? get() = definedExternally; set(value) = definedExternally
    var borderColor: String? get() = definedExternally; set(value) = definedExternally
    var channelNumber: String? get() = definedExternally; set(value) = definedExternally
    var format: AdFormat? get() = definedExternally; set(value) = definedExternally
    var map: Map? get() = definedExternally; set(value) = definedExternally
    var position: ControlPosition? get() = definedExternally; set(value) = definedExternally
    var publisherId: String? get() = definedExternally; set(value) = definedExternally
    var textColor: String? get() = definedExternally; set(value) = definedExternally
    var titleColor: String? get() = definedExternally; set(value) = definedExternally
    var urlColor: String? get() = definedExternally; set(value) = definedExternally
}
external enum class AdFormat {
    BANNER,
    BUTTON,
    HALF_BANNER,
    LARGE_HORIZONTAL_LINK_UNIT,
    LARGE_RECTANGLE,
    LARGE_VERTICAL_LINK_UNIT,
    LEADERBOARD,
    MEDIUM_RECTANGLE,
    MEDIUM_VERTICAL_LINK_UNIT,
    SKYSCRAPER,
    SMALL_HORIZONTAL_LINK_UNIT,
    SMALL_RECTANGLE,
    SMALL_SQUARE,
    SMALL_VERTICAL_LINK_UNIT,
    SQUARE,
    VERTICAL_BANNER,
    WIDE_SKYSCRAPER,
    X_LARGE_VERTICAL_LINK_UNIT
}
