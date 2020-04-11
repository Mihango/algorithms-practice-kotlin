package labs.khobfa.queue

import labs.khobfa.lists.Employee
import labs.khobfa.stacks.checkIfIsPalindrome
import java.util.*
import kotlin.NoSuchElementException
import kotlin.math.sign

fun main() {
    val jane = Employee("Jane", "Smith", 3)
    val job = Employee("Job", "Rhyan", 4)
    val mohammed = Employee("Mohamed", "Yusuf", 5)
    val rhyan = Employee("Rhyan", "Jimmy", 6)

    val queue = ArrayQueue()
    queue.enqueue(jane)
    queue.enqueue(job)
    queue.enqueue(mohammed)
    queue.enqueue(rhyan)

    queue.printAll()

    println()
    println("Dequeue --->>>> ${queue.dequeue()}")
    println()
    queue.printAll()

    queue.enqueue(job)
    queue.enqueue(mohammed)
    queue.enqueue(rhyan)
    println()
    queue.printAll()

    queue.dequeue()
    queue.dequeue()
    queue.dequeue()
    queue.dequeue()
    queue.dequeue()
    println()
    queue.printAll()
}

class ArrayQueue(capacity: Int = 5) {
    var queue = arrayOfNulls<Employee>(capacity)
    private var back: Int = 0
    private var front: Int = 0

    fun enqueue(employee: Employee) {
        if(back == queue.size) {
            val newArray = arrayOfNulls<Employee>(2 * queue.size)
            System.arraycopy(queue, 0, newArray, 0, queue.size)
            queue = newArray
        }
        queue[back++] =  employee
    }

    @Throws(NoSuchElementException::class)
    fun dequeue(): Employee? {
        if(back == 0) {
            throw NoSuchElementException()
        }
        val emp = queue[front]
        queue[front] = null
        front++
        if(getSize() == 0) {
            front = 0
            back = 0
        }
        return emp
    }

    fun printAll() {
        for (i in front until back) {
            println(queue[i])
        }
    }

    fun isEmpty():Boolean = back - front == 0
    fun getSize():Int = back - front
}