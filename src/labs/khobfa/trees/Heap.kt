package labs.khobfa.trees

import java.lang.IndexOutOfBoundsException

fun main() {
    val heap = Heap(10)
    heap.insert(10)
    heap.insert(4)
    heap.insert(20)

    heap.printAll()
}

class Heap(size: Int = 5) {
    private var heap = IntArray(size)
    private var size= 0

    fun insert(value: Int) {
        if(isFull())
            throw IndexOutOfBoundsException("Heap is full")

        heap[size] = value

        if(value > heap[getParent(size)]) {
            fixIndexAbove(size)
        }

        ++size
    }



    private fun fixIndexAbove(newIndex: Int) {
        var index = newIndex
        val value = heap[index]

        while (index > 0 && value > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)]
            index = getParent(index)
        }
        heap[index] = value
    }

    fun isFull(): Boolean = size == heap.size

    fun getParent(index: Int) = (index - 1) / 2

    fun printAll() {
        println("Heap >>>> size: $size >>>> data: ${heap.contentToString()}")
    }
}