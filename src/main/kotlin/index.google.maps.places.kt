@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsQualifier("google.maps.places")
package google.maps.places

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

external open class Autocomplete(inputField: HTMLInputElement, opts: AutocompleteOptions? = definedExternally /* null */) : MVCObject {
    open fun getBounds(): LatLngBounds = definedExternally
    open fun getPlace(): PlaceResult = definedExternally
    open fun setBounds(bounds: LatLngBounds): Unit = definedExternally
    //open fun setBounds(bounds: LatLngBoundsLiteral): Unit = definedExternally
    open fun setComponentRestrictions(restrictions: ComponentRestrictions): Unit = definedExternally
    open fun setTypes(types: Array<String>): Unit = definedExternally
}
external interface AutocompleteOptions {
    var bounds: dynamic /* LatLngBounds | LatLngBoundsLiteral */ get() = definedExternally; set(value) = definedExternally
    var componentRestrictions: ComponentRestrictions? get() = definedExternally; set(value) = definedExternally
    var placeIdOnly: Boolean? get() = definedExternally; set(value) = definedExternally
    var strictBounds: Boolean? get() = definedExternally; set(value) = definedExternally
    var types: Array<String>? get() = definedExternally; set(value) = definedExternally
    var type: String? get() = definedExternally; set(value) = definedExternally
}
external interface AutocompletePrediction {
    var description: String
    var matched_substrings: Array<PredictionSubstring>
    var place_id: String
    var reference: String
    var structured_formatting: AutocompleteStructuredFormatting
    var terms: Array<PredictionTerm>
    var types: Array<String>
}
external interface AutocompleteStructuredFormatting {
    var main_text: String
    var main_text_matched_substrings: Array<PredictionSubstring>
    var secondary_text: String
}
external interface OpeningHours {
    var open_now: Boolean
    var periods: Array<OpeningPeriod>
    var weekday_text: Array<String>
}
external interface OpeningPeriod {
    var open: OpeningHoursTime
    var close: OpeningHoursTime? get() = definedExternally; set(value) = definedExternally
}
external interface OpeningHoursTime {
    var day: Number
    var hours: Number
    var minutes: Number
    var nextDate: Number
    var time: String
}
external interface PredictionTerm {
    var offset: Number
    var value: String
}
external interface PredictionSubstring {
    var length: Number
    var offset: Number
}
external open class AutocompleteService {
    open fun getPlacePredictions(request: AutocompletionRequest, callback: (result: Array<AutocompletePrediction>, status: PlacesServiceStatus) -> Unit): Unit = definedExternally
    open fun getQueryPredictions(request: QueryAutocompletionRequest, callback: (result: Array<QueryAutocompletePrediction>, status: PlacesServiceStatus) -> Unit): Unit = definedExternally
}
external interface AutocompletionRequest {
    var bounds: dynamic /* LatLngBounds | LatLngBoundsLiteral */ get() = definedExternally; set(value) = definedExternally
    var componentRestrictions: ComponentRestrictions? get() = definedExternally; set(value) = definedExternally
    var input: String
    var location: LatLng? get() = definedExternally; set(value) = definedExternally
    var offset: Number? get() = definedExternally; set(value) = definedExternally
    var radius: Number? get() = definedExternally; set(value) = definedExternally
    var types: Array<String>? get() = definedExternally; set(value) = definedExternally
}
external interface ComponentRestrictions {
    var country: dynamic /* String | Array<String> */
}
external interface PlaceAspectRating {
    var rating: Number
    var type: String
}
external interface PlaceDetailsRequest {
    var placeId: String
}
external interface PlaceGeometry {
    var location: LatLng
    var viewport: LatLngBounds
}
external interface PlacePhoto {
    var height: Number
    var html_attributions: Array<String>
    var width: Number
    fun getUrl(opts: PhotoOptions): String
}
external interface PhotoOptions {
    var maxHeight: Number? get() = definedExternally; set(value) = definedExternally
    var maxWidth: Number? get() = definedExternally; set(value) = definedExternally
}
external interface PlaceResult {
    var address_components: Array<GeocoderAddressComponent>
    var adr_address: String
    var formatted_address: String
    var formatted_phone_number: String
    var geometry: PlaceGeometry
    var html_attributions: Array<String>
    var icon: String
    var id: String
    var international_phone_number: String
    var name: String
    var opening_hours: OpeningHours
    var permanently_closed: Boolean
    var photos: Array<PlacePhoto>
    var place_id: String
    var price_level: Number
    var rating: Number
    var reviews: Array<PlaceReview>
    var types: Array<String>
    var url: String
    var utc_offset: Number
    var vicinity: String
    var website: String
}
external interface PlaceReview {
    var aspects: Array<PlaceAspectRating>
    var author_name: String
    var author_url: String
    var language: String
    var text: String
}
external interface PlaceSearchPagination {
    fun nextPage()
    var hasNextPage: Boolean
}
external interface PlaceSearchRequest {
    var bounds: dynamic /* LatLngBounds | LatLngBoundsLiteral */ get() = definedExternally; set(value) = definedExternally
    var keyword: String? get() = definedExternally; set(value) = definedExternally
    var location: dynamic /* LatLng | LatLngLiteral */ get() = definedExternally; set(value) = definedExternally
    var maxPriceLevel: Number? get() = definedExternally; set(value) = definedExternally
    var minPriceLevel: Number? get() = definedExternally; set(value) = definedExternally
    var name: String? get() = definedExternally; set(value) = definedExternally
    var openNow: Boolean? get() = definedExternally; set(value) = definedExternally
    var radius: Number? get() = definedExternally; set(value) = definedExternally
    var rankBy: RankBy? get() = definedExternally; set(value) = definedExternally
    var types: Array<String>? get() = definedExternally; set(value) = definedExternally
    var type: String? get() = definedExternally; set(value) = definedExternally
}
external open class PlacesService {
    constructor(attrContainer: HTMLDivElement)
    constructor(attrContainer: Map)
    open fun getDetails(request: PlaceDetailsRequest, callback: (result: PlaceResult, status: PlacesServiceStatus) -> Unit): Unit = definedExternally
    open fun nearbySearch(request: PlaceSearchRequest, callback: (results: Array<PlaceResult>, status: PlacesServiceStatus, pagination: PlaceSearchPagination) -> Unit): Unit = definedExternally
    open fun radarSearch(request: RadarSearchRequest, callback: (results: Array<PlaceResult>, status: PlacesServiceStatus) -> Unit): Unit = definedExternally
    open fun textSearch(request: TextSearchRequest, callback: (results: Array<PlaceResult>, status: PlacesServiceStatus, pagination: PlaceSearchPagination) -> Unit): Unit = definedExternally
}
external enum class PlacesServiceStatus {
    INVALID_REQUEST,
    OK,
    OVER_QUERY_LIMIT,
    REQUEST_DENIED,
    UNKNOWN_ERROR,
    ZERO_RESULTS
}
external interface QueryAutocompletePrediction {
    var description: String
    var matched_substrings: Array<PredictionSubstring>
    var place_id: String
    var terms: Array<PredictionTerm>
}
external interface QueryAutocompletionRequest {
    var bounds: dynamic /* LatLngBounds | LatLngBoundsLiteral */ get() = definedExternally; set(value) = definedExternally
    var input: String? get() = definedExternally; set(value) = definedExternally
    var location: LatLng? get() = definedExternally; set(value) = definedExternally
    var offset: Number? get() = definedExternally; set(value) = definedExternally
    var radius: Number? get() = definedExternally; set(value) = definedExternally
}
external interface RadarSearchRequest {
    var bounds: dynamic /* LatLngBounds | LatLngBoundsLiteral */ get() = definedExternally; set(value) = definedExternally
    var keyword: String? get() = definedExternally; set(value) = definedExternally
    var location: dynamic /* LatLng | LatLngLiteral */ get() = definedExternally; set(value) = definedExternally
    var name: String? get() = definedExternally; set(value) = definedExternally
    var radius: Number? get() = definedExternally; set(value) = definedExternally
    var types: Array<String>? get() = definedExternally; set(value) = definedExternally
    var type: String? get() = definedExternally; set(value) = definedExternally
}
external enum class RankBy {
    DISTANCE,
    PROMINENCE
}
external open class SearchBox(inputField: HTMLInputElement, opts: SearchBoxOptions? = definedExternally /* null */) : MVCObject {
    open fun getBounds(): LatLngBounds = definedExternally
    open fun getPlaces(): Array<PlaceResult> = definedExternally
    open fun setBounds(bounds: LatLngBounds): Unit = definedExternally
    //open fun setBounds(bounds: LatLngBoundsLiteral): Unit = definedExternally
}
external interface SearchBoxOptions {
    var bounds: dynamic /* LatLngBounds | LatLngBoundsLiteral */
}
external interface TextSearchRequest {
    var bounds: dynamic /* LatLngBounds | LatLngBoundsLiteral */ get() = definedExternally; set(value) = definedExternally
    var location: dynamic /* LatLng | LatLngLiteral */ get() = definedExternally; set(value) = definedExternally
    var query: String
    var radius: Number? get() = definedExternally; set(value) = definedExternally
    var types: Array<String>? get() = definedExternally; set(value) = definedExternally
    var type: String? get() = definedExternally; set(value) = definedExternally
}
