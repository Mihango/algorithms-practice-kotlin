package labs.khobfa.arrays

fun main() {
    val data = intArrayOf(9,8,6,5,1,-2)
    var j = 0
    println("array[2++] =>>>> ${data[++j]}")

    // copy arrays
    val datCopy = IntArray(3)
    System.arraycopy(data, 2, datCopy, 1, 0)
    println("Copies Data >>>> ${datCopy.contentToString()} ")
}