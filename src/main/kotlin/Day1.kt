import java.io.File

fun main() {
    val measurementDataFileName = "/Users/adyanf/Learn/Algorithm/AdventOfCode/src/main/resources/day1.txt"
    val measurementData = File(measurementDataFileName).readLines()
    val measurements = measurementData.map { it.toInt() }
    println("Single Measurement: " + largerThanPreviousMeasurement(measurements))
    println("Window Measurement: " +  largerThanPreviousMeasurementWindow(measurements))
}

private fun largerThanPreviousMeasurement(measurements: List<Int>): Int {
    var largerThatPrevious = 0
    for (i in 1 until measurements.size) {
        if (measurements[i] > measurements[i-1]) {
            largerThatPrevious++
        }
    }
    return largerThatPrevious
}

private fun largerThanPreviousMeasurementWindow(measurements: List<Int>): Int {
    var largerThatPrevious = 0
    for (i in 3 until measurements.size) {
        if (measurements[i] > measurements[i-3]) {
            largerThatPrevious++
        }
    }
    return largerThatPrevious
}