package labs.khobfa.sort

import kotlin.system.measureTimeMillis

fun main() {
    val data = intArrayOf(20, 35, -15, 7, 55, 1, -22, 5)
    val timeTaken = measureTimeMillis {
        // insertionSort(data)
        insertionSortRecursive(data, data.size)
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

fun insertionSort_2(data: IntArray) {
    for (firstUnsortedIndex in 1 until data.size) {
        val newElement = data[firstUnsortedIndex]
        var i: Int
        i = firstUnsortedIndex
        while (i > 0 && data[i - 1] > newElement) {
            data[i] = data[i - 1]
            i--
        }
        data[i] = newElement
    }
}

fun insertionSortRecursive(data: IntArray, items: Int) {
    if(items < 2) {
        return
    }

    insertionSortRecursive(data, items - 1)

    val newElement = data[items-1]
    var i: Int = items - 1
    while (i > 0 && data[i - 1] > newElement) {
        data[i] = data[i - 1]
        i--
    }
    data[i] = newElement
}
