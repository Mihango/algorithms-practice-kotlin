package labs.khobfa.sort

fun main() {
    val data = intArrayOf(8, -1, 3, 4)
    selectionSort(data)
    println("Sorted Array >>>>> ${data.contentToString()}")
}

fun selectionSort(data: IntArray) {
    var lastUnsortedIndex = data.size - 1
    for(i in data.indices) {
        var largest = 0
        for (i in 1..lastUnsortedIndex) {
            if(data[i] > data[largest]) {
                largest = i
            }
        }
        swap(data, largest, lastUnsortedIndex)
        lastUnsortedIndex -= 1
    }
}