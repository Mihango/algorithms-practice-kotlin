package labs.khobfa.sort

import kotlin.system.measureTimeMillis

/**
 * finds largest no. and swap the no with last sorted index
 */
fun main() {
    val data = intArrayOf(8, -1, 3, 4)
    val timeTaken = measureTimeMillis {
        selectionSort(data)
    }
    println("Sorted Array >>>>> ${data.contentToString()} >>>>>>> time taken $timeTaken")
}

fun selectionSort(data: IntArray) {
    var lastUnsortedIndex = data.size - 1
    for(i in data.indices) {
        var largest = 0
        for (i in 1..lastUnsortedIndex) {
            if(data[i] > data[largest]) {
                largest = i
            }
        }
        swap(data, largest, lastUnsortedIndex)
        lastUnsortedIndex -= 1
    }
}