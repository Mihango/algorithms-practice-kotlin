package labs.khobfa.arrays

import labs.khobfa.sort.swap

fun main() {
    val data = intArrayOf(1, 3, 3, 3, 5)
    println("Missing nos >>>>>>> ${findMissingCountingSort(data, 1, 5).toIntArray().contentToString()}")

}

fun findMissingElement(data: IntArray): List<Int> {
    // empty list to hold numbers
    val missingNos = mutableListOf<Int>()
    // sort the array -- using selection sort
    for (lastUnsorted in data.size - 1 downTo 1) {
        var largest = 0
        for (i in 1..lastUnsorted) {
            if (data[i] > data[largest]) {
                largest = i
            }
        }
        swap(data, lastUnsorted, largest)
    }

    // if sorted is greater than one
    // 0 3 4 - 4(size -1) , 3(size -2)=i
    for (i in data.size - 2 downTo 0) {
        var bigger = data[i]
        if (bigger != data[i + 1]) {
            while (bigger < data[i + 1] - 1) {
                missingNos.add(++bigger)
            }
        }
    }
    println("Sorted array ${data.contentToString()}")
    return missingNos
}

// 1, 3, 3, 3, 5
fun findMissingCountingSort(data: IntArray, min: Int, max: Int): List<Int> {
    val counting = IntArray((max - min) + 1) { 0 }
    val missing = mutableListOf<Int>()
    for (i in data.indices) {
        counting[data[i] - min]++
    }
    for (i in min..max) {
        if (counting[i - min] == 0) {
            missing.add(i)
        }
    }
    return missing
}

fun binaryToDecimal(n: String): Int {
    var dec_value = 0

    // Initializing base value to 1,
    // i.e 2^0
    var base = 1
    val len = n.length
    for (i in len - 1 downTo 0) {
        if (n[i] == '1') dec_value += base
        base = base * 2
    }
    return dec_value
}