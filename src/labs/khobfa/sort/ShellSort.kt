package labs.khobfa.sort

import kotlin.math.pow
import kotlin.system.measureTimeMillis

/**
 * variation of insertion sort algorithm - insertion chooses which element to insert
 * to using a gap of 1
 * Shell sort starts out using a larger gap value reducing the gapas it runs
 * the goal is to reduce amount of shifting
 *
 * unstable algorithm
 */
fun main() {
    val data = intArrayOf(20, 35, -15, 7, 55, 1, -22)
    val timeTaken = measureTimeMillis {
        shellSort(data)
    }
    println("Sorted array >>>> ${data.contentToString()} >>>> time taken: $timeTaken")
}

fun shellSort(data: IntArray) {
    var gap = data.size / 2
    while (gap > 0) {
        for (i in gap until data.size) {
            val newElement = data[i]
            var j = i
            while (j >= gap && data[j - gap] > newElement) {
                data[j] = data[j - gap]
                j -= gap
            }
            data[j] = newElement
        }
        gap /= 2
    }
}

fun calculateKnuthGap(size: Int): Int {
    val gap = (3.toDouble().pow(size) - 1) / 2
    println("Gap >>>>>> ${gap.toInt()}")
    return gap.toInt()
}