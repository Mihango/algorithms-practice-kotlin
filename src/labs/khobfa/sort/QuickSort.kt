package labs.khobfa.sort

fun main() {
    val input = intArrayOf(20, 35, -15, 7, 55, 1, -22)
    quickSort(input, 0, input.size)
    println("Sorted array >>>>>> ${input.contentToString()}")
}

fun quickSort(data: IntArray, start: Int, end: Int) {
    // check condition to stop recursive call -- there should only be one element
    if(end - start < 2) {
        return
    }

    val pivot = partition(data, start, end)
    quickSort(data, start, pivot)
    quickSort(data, pivot + 1, end)
}

fun partition(data: IntArray, start: Int, end: Int): Int {
    var i = start
    var j = end
    // use start as pivot
    val pivot = data[start]

    while (i < j) {
        while (i<j && data[--j] >= pivot);

        if(i < j) {
            data[i] = data[j]
        }

        while (i < j && data[++i] <= pivot);

        if(i < j) {
            data[j] = data[i]
        }
    }

    data[j] = pivot

    return j
}