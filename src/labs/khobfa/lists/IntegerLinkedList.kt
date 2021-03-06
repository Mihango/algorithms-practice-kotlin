package labs.khobfa.lists

fun main() {
    val data = intArrayOf(4, 2, 1, 5)
    val linkedList = IntegerLinkedList()
    data.forEach { linkedList.insertSorted(it) }
    linkedList.printAll()
}

class IntegerLinkedList {
    private var head: IntegerNode? = null
    private var size: Int = 0

    fun addToHead(item: Int) {
        val newNode = IntegerNode(item, head)
        head = newNode
        ++size
    }

    fun insertSorted(item: Int) {
        if (head == null || head!!.value > item) {
            addToHead(item)
            return
        }
        var current = head?.next
        var previous = head
        while (current != null && current.value < item) {
            previous = current
            current = current.next
        }

        val newNode = IntegerNode(item, current)
        previous?.next = newNode
        ++size
    }

    private fun sortAndAddList(item: Int) {
        val nodes = ArrayList<IntegerNode?>()
        var current = head
        while (current != null && current.value < item) {
            nodes.add(current)
            current = removeItem()?.next
        }
        val node = IntegerNode(item, nodes.last()?.next)
        nodes.last()?.next = node
        head = nodes.first()
        println("Sort called ${nodes.size}")
    }

    fun removeItem(): IntegerNode? {
        val removedNode = head
        head = removedNode?.next
        --size
        return removedNode
    }

    fun getSize(): Int = size
    fun printAll() {
        while (head != null) {
            print(" ${head?.value}")
            head = head?.next
        }
    }
}

data class IntegerNode(val value: Int, var next: IntegerNode? = null)