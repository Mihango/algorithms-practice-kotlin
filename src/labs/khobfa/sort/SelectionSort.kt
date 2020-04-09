package labs.khobfa.sort

import kotlin.system.measureTimeMillis

/**
 * finds largest no. and swap the no with last sorted index
 */
fun main() {
    val data = intArrayOf(20, 35, -15, 7, 55, 1, -22)
    val timeTaken = measureTimeMillis {
        selectionSort(data)
    }
    println("Sorted Array >>>>> ${data.contentToString()} >>>>>>> time taken $timeTaken")
}

fun selectionSort(data: IntArray) {
    for(lastUnsorted in data.size - 1 downTo 1) {
        var largest = 0
        for(i in 1..lastUnsorted) {
            if(data[i] > data[largest]) {
                largest = i
            }
        }
        swap(data, lastUnsorted, largest)
    }
}