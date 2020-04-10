package labs.khobfa.lists

import kotlin.system.measureTimeMillis


fun main() {
    val timeTaken = measureTimeMillis {
        val jane = Employee("Jane", "Smith", 1)
        val job = Employee("Job", "Rhyan", 2)
        val mohammed = Employee("Mohamed", "Yusuf", 3)

        val linkedList = EmployeeLinkedList()

        // test if is empty
        println(">>>> linked list is empty ? ${linkedList.isEmpty()}")
        println()

        linkedList.addToFront(jane)
        linkedList.addToFront(job)
        linkedList.addToFront(mohammed)

        println("Linked list size ${linkedList.getSize()}")
        linkedList.printAll()
        println()

        linkedList.removeFromFront()
        println("Linked list size ${linkedList.getSize()}")
        linkedList.printAll()
        println()

    }

    println("Time Taken >>>>>>> $timeTaken")
}

/**
 * Singly linked list
 */
class EmployeeLinkedList() {
    private var head: EmployeeNode? = null
    private var size: Int = 0

    fun addToFront(employee: Employee) {
        val node = EmployeeNode(employee, head)
        head = node
        size++
    }

    fun removeFromFront(): EmployeeNode? {
        println("Removing item")
        val removedNode = head
        head = removedNode?.next
        size--
        removedNode?.next = null
        return removedNode
    }

    fun getSize(): Int = size
    fun isEmpty(): Boolean = head == null
    fun printAll() {
        var current = head
        while (current?.employee != null) {
            print(" Node >>>. $current ")
            current = current.next
        }
        print("Last node null")
    }
}

// employee pojo
data class Employee(val firstName: String, val lastName: String, val id: Int)

// a node to be used in linked list
data class EmployeeNode(val employee: Employee, var next: EmployeeNode?) {
    override fun toString(): String {
        return employee.toString()
    }
}