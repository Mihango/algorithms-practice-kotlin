package labs.khobfa.search

fun main() {
    val data = intArrayOf(20, 35, -15, 7, 55, 1, -22)
    println("Find -22 >>> ${linearSearch(data, -22)}")
    println("Out of array 4 >>> ${linearSearch(data, 3)}")
}

/***
 * Time complexity id O(n)
 */
fun linearSearch(data: IntArray, value: Int): Int {
    for (i in data.indices) {
        if(data[i] == value)
            return i
    }
    return -1
}