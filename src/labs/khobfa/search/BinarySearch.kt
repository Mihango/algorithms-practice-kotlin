package labs.khobfa.search

fun main() {
    val data = intArrayOf(20, 35, -15, 7, 55, 1, -22)
    // sort the array first before you search
    labs.khobfa.sort.quickSort(data, 0, data.size)

    println("================= Iterative Binary Search ================")
    println("Find -22 >>> ${data.contentToString()} >>>>>>>>>>> ${iterativeBinarySearch(data, -22)}")
    println("Out of array 4 >>> ${data.contentToString()} >>>>>>>>>>> ${iterativeBinarySearch(data, 3)}")

    println("================= Recursive Binary Search ================")
    println("Find -22 >>> ${data.contentToString()} >>>>>>>>>>> ${recursiveBinarySearch(data, -22)}")
    println("Out of array 4 >>> ${data.contentToString()} >>>>>>>>>>> ${recursiveBinarySearch(data, 3)}")

}

fun iterativeBinarySearch(data:IntArray, value: Int): Int {
    var start = 0
    var end = data.size

    while (start < end) {
        val midpoint = (start + end) / 2
        when {
            data[midpoint] == value -> {
                return midpoint
            }
            data[midpoint] < value -> {
                start = midpoint + 1
            }
            else -> {
                end = midpoint
            }
        }
    }
    return -1
}

fun recursiveBinarySearch(data:IntArray, value: Int): Int {
    return recursiveBinarySearch(data, value, 0, data.size )
}

fun recursiveBinarySearch(data:IntArray, value: Int, start: Int, end: Int): Int {
    if(start >= end) {
        return -1
    }

    val midpoint = (start + end) / 2
    return when {
        data[midpoint] == value -> {
            midpoint
        }
        data[midpoint] < value -> {
            recursiveBinarySearch(data, value, midpoint+1, end)
        }
        else -> {
            recursiveBinarySearch(data, value, start, midpoint)
        }
    }
}