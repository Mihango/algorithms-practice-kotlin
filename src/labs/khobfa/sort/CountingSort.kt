package labs.khobfa.sort

/**
 * Counting array sorts positive number and a specific range
 * cannot sort floating numbers and Strings
 */
fun main() {
    val data = intArrayOf(2, 5, 9, 8, 2, 8, 7,10, 4, 3)

    countingSort(data, 1, 10)

    println("Sorted Array >>>>>> ${data.contentToString()}")
}

fun countingSort(data: IntArray, min: Int, max: Int) {
    val countArray = IntArray((max - min) + 1)

    for(i in data.indices) {
        countArray[data[i] - min]++
    }

    var j = 0
    for(i in min..max) {
        while (countArray[i-min] > 0) {
            data[j++] = i
            countArray[i - min]--
        }
    }
}