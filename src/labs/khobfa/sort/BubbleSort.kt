package labs.khobfa.sort

import kotlin.system.measureTimeMillis

/**
 * degrades quickly with number of items
 * in-place algorithm - logically partitioning array rather than
 * creating a new array
 * O(n^2) time complexity- quadratic
 */
fun main() {
    val data = intArrayOf(20, 35, -15, 7, 55, 1, -22)
    val timeTaken = measureTimeMillis {
        bubbleSortDesc(data)
    }
    println("Sorted Array >>>>> ${data.contentToString()} >>>>> time take = $timeTaken")
}

fun bubbleSortAsc(data: IntArray) {

    for(lastSorted in data.size - 1 downTo 1) {
        for (i in 0 until lastSorted) {
            if(data[i] > data[i+1]) {
                swap(data, i, i+1)
            }
        }
    }
}

fun bubbleSortDesc(data: IntArray) {
    for(lastSorted in data.size - 1 downTo 1) {
        for (i in 0 until lastSorted) {
            if(data[i] < data[i+1]) {
                swap(data, i, i+1)
            }
        }
    }
}

/**
 * sorting from right - ascending order - look for largest item
 * navigate from left to right
 */
fun bubbleSort(data: IntArray) {
    for(i in data.indices) {
        for(j in i+1 until data.size) {
            if(data[i] > data[j])
                swap(data, i, j)
        }
    }
}

fun bubbleSortDescLeft(data: IntArray) {
    for(i in data.indices) {
        for(j in i+1 until data.size) {
            if(data[i] < data[j])
                swap(data, i, j)
        }
    }
}

fun swap(data: IntArray, i: Int, j: Int) {
    if(i == j) {
        return
    }

    val temp = data[i]
    data[i] = data[j]
    data[j] = temp
}

