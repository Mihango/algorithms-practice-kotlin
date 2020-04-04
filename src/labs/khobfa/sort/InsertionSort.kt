package labs.khobfa.sort

import kotlin.system.measureTimeMillis

fun main() {
    val data = intArrayOf(20, 35, -15, 7, 55, 1, -22, 5)
    val timeTaken = measureTimeMillis {
        insertionSort(data)
    }
    println("Sorted >>>>>>>> ${data.contentToString()} >>>>>>> time take: $timeTaken ")
}

// insertion sort
fun insertionSort(items: IntArray) {
    for(i in 1 until items.size) {
        val item = items[i]
        var j = i - 1;
        while (j >= 0 && items[j] > item) {
            items[j + 1] = items[j]
            j -= 1
        }
        items[j + 1 ] = item
    }
}
