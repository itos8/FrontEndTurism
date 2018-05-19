package frontEnd

import google.maps.Polygon

data class Point(val position: Position, val name: String, val description: String, val polygon: Array<Position>, val image: String)
data class PointOfInterest(val lat: Double, val lon: Double, val name: String, val description: String, val image: String)
data class Position (val lat: Double, val lon: Double)