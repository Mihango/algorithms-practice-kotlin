package labs.khobfa.lists

import java.lang.Exception
import kotlin.system.measureTimeMillis

fun main() {
    val timeTaken = measureTimeMillis {
        val jane = Employee("Jane", "Smith", 3)
        val job = Employee("Job", "Rhyan", 4)
        val mohammed = Employee("Mohamed", "Yusuf", 5)

        val rhyan = Employee("Rhyan", "Jimmy", 6)
        val job2 = Employee("Jobs", "Rhyan-", 9)



        val linkedList = DoubleLinkedList()

        // test if is empty
//        println(">>>> linked list is empty ? ${linkedList.isEmpty()}")
//        println()

        linkedList.addItemToHead(jane)
        linkedList.addItemToHead(job)
        linkedList.addItemToHead(mohammed)

        linkedList.printAll()
        println()
//        println(">>>> linked list size? ${linkedList.getSize()}")

        linkedList.addBefore(rhyan, job)
        linkedList.printAll()
//        println()
//        println(">>>> linked list size ? ${linkedList.getSize()}")
    }
}

data class DoubleEmployeeNode(val employee: Employee, var previous: DoubleEmployeeNode? = null, var next: DoubleEmployeeNode? = null) {
    override fun toString(): String {
        return employee.toString()
    }
}

class DoubleLinkedList {
    private var size: Int = 0
    var head: DoubleEmployeeNode? = null
    private var tail: DoubleEmployeeNode? = null

    fun addItemToHead(emp: Employee) {
        val newNode: DoubleEmployeeNode
        if(head != null) {
            newNode = DoubleEmployeeNode(emp, null, head)
            head!!.previous = newNode
        } else {
            newNode = DoubleEmployeeNode(emp, head, tail)
            tail = newNode
        }
        head = newNode
        ++size
    }

    fun getSize(): Int = size
    fun isEmpty(): Boolean = head == null
    fun printAll() {
        var current = head
        while (current != null) {
            println(" Node >>>. $current ")
            current = current.next
        }
        print("Last node null")
    }

    @Throws(Exception::class)
    fun addBefore(newEmployee: Employee, existingEmp: Employee) {
        // find the employee
        var currentNode = head

        if(currentNode?.employee != existingEmp) {
            while (currentNode?.employee != null){
                if(currentNode.employee == existingEmp) {
                    currentNode = currentNode
                    break
                }
                currentNode = currentNode.next
            }
        }

        if(currentNode != null) {
            val newNode = DoubleEmployeeNode(newEmployee, currentNode.previous, currentNode)
            currentNode.previous = newNode
            println("Previous next === should be new ${currentNode.previous!!.next}")

            if(head == currentNode) {
                head = newNode
            } else {
                newNode.previous!!.next = newNode
            }
        } else {
            throw Exception("Employee not found")
        }
    }
}