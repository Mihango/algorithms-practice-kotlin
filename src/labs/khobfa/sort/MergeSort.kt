package labs.khobfa.sort

import kotlin.system.measureTimeMillis

fun main() {
    val input = intArrayOf(4, 6, 3, -1, 2, 0)
    val timeSpent = measureTimeMillis {
        mergeSort(input)
        println("Merge items  ${input.contentToString()}")
    }
    println("Time spent $timeSpent")
}

fun mergeSort(data: IntArray, start: Int = 0, end: Int = data.size) {
    // break the loop if only one item is remaining
    if(end - start < 2) {
        return
    }

    // find the mid
    val mid = (start + end) / 2

    // call recursively
    mergeSort(data, start, mid)
    mergeSort(data, mid, end)
//    merge(data, start, mid, end)
    mergeDesc(data, start, mid, end)
}

fun merge(data: IntArray, start: Int, mid: Int, end: Int) {
    if(data[mid-1] <= data[mid]) {
        return
    }

    var i = start
    var j = mid
    var tempIndex = 0 // keeps counter of how many items moved
    var temp = IntArray(end - start) // create a temporary array to hold items moved

    while(i < mid && j < end) {
        // this will sort element and add them to temp array - it may not handle every element and some are left - do below
        temp[tempIndex++] = if(data[i] <= data[j]) data[i++] else data[j++]
    }

    // handle items left - copy all items from input from tempIndex
    System.arraycopy(data, i, data, start + tempIndex, mid - i)
    // copy item in temp to fill main array from start
    System.arraycopy(temp, 0, data, start, tempIndex)
}

fun mergeDesc(data: IntArray, start: Int, mid: Int, end: Int) {
    if(data[mid-1] >= data[mid]) {
        return
    }

    var i = start
    var j = mid
    var tempIndex = 0

    val temp = IntArray(end - start)
    while (i < mid && j < end) {
        temp[tempIndex++] = if(data[i] <= data[j]) data[j++] else data[i++]
    }
    System.arraycopy(data, start, data, start+tempIndex, mid - i)
    System.arraycopy(temp, 0, data, start, tempIndex)
}