import java.io.File

fun main() {
    val submarineDirectionsDataFileName = "/Users/adyanf/Learn/Algorithm/AdventOfCode/src/main/resources/day2.txt"
    val submarineDirectionsData = File(submarineDirectionsDataFileName).readLines()
    val submarineDirections = submarineDirectionsData.map {
        val (action, x) = it.split(" ")
        action to x.toInt()
    }
    println("Calculate horizontal and depth position: " + calculateHorizontalAndDepthPosition(submarineDirections))
    println("Calculate horizontal, depth position, and aim: " + calculateHorizontalDepthPositionAndAim(submarineDirections))
}

private fun calculateHorizontalAndDepthPosition(submarineDirections: List<Pair<String, Int>>): Int {
    var horizontalPosition = 0
    var depthPosition = 0
    submarineDirections.forEach { (action, x) ->
        when(action) {
            "forward" -> horizontalPosition += x
            "up" -> depthPosition -= x
            "down" -> depthPosition += x
        }
    }
    return horizontalPosition * depthPosition
}

private fun calculateHorizontalDepthPositionAndAim(submarineDirections: List<Pair<String, Int>>): Int {
    var horizontalPosition = 0
    var depthPosition = 0
    var aim = 0
    submarineDirections.forEach { (action, x) ->
        when(action) {
            "forward" -> {
                horizontalPosition += x
                depthPosition += (aim * x)
            }
            "up" -> aim -= x
            "down" -> aim += x
        }
    }
    return horizontalPosition * depthPosition
}