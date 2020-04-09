package labs.khobfa.sort

import kotlin.system.measureTimeMillis

fun main() {
    val data = intArrayOf(20, 35, -15, 7, 55, 1, -22, 5)
    val timeTaken = measureTimeMillis {
        insertionSort(data)
    }
    println("Sorted >>>>>>>> ${data.contentToString()} >>>>>>> time take: $timeTaken ")
}

fun insertionSort(data: IntArray) {
    for(firstUnsortedIndex in 1 until data.size) {
        val item = data[firstUnsortedIndex]
        var j = firstUnsortedIndex-1

        while (j >=0 && data[j] > item) {
            data[j+1] = data[j]
            j -= 1
        }
        data[j + 1] = item
    }
}
