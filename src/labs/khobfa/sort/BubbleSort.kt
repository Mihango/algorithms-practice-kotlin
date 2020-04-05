package labs.khobfa.sort

/**
 * degrades quickly with number of items
 * in-place algorithm - logically partitioning array rather than
 * creating a new array
 * O(n^2) time complexity- quadratic
 */
fun main() {
//    val data = intArrayOf(8, 4, -1, 3)
    val data = intArrayOf(8, -1, 3, 4)
    bubbleSort(data)
    println("Sorted Array >>>>> ${data.contentToString()}")
}

fun bubbleSort(data: IntArray) {
    var count = 0
    for(lastUnsortedIndex in data.size - 1 downTo 0) {
        count += 1
        for(i in 0 until lastUnsortedIndex) {
            if(data[i] > data[i+1]) {
                swap(data, i, i+1)
            }
        }
        println("Loops completed >>>>>>>>> $count")
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

