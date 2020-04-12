package labs.khobfa.queue

import labs.khobfa.lists.Employee

fun main() {
    val queue = CircularQueue(3)

    val jane = Employee("Jane", "Smith", 3)
    val job = Employee("Job", "Rhyan", 4)
    val mohammed = Employee("Mohamed", "Yusuf", 5)
    val rhyan = Employee("Rhyan", "Jimmy", 6)

    queue.enqueue(jane)
    queue.enqueue(job)
    // queue.dequeue()
    queue.enqueue(mohammed)
    // queue.dequeue()
    queue.enqueue(rhyan)

    queue.printAll()
}

class CircularQueue(capacity: Int = 5) {
    var queue = arrayOfNulls<Employee>(capacity)
    private var back: Int = 0;
    private var front: Int = 0;

    fun enqueue(employee: Employee) {
        if(size() == queue.size - 1) {
            val numItems = size()
            val newArray = arrayOfNulls<Employee>(2 * queue.size)
            // add data from front to end of array -- then add the remaining from 0 to front
            val tempIndex = queue.size - front
            if(front == 0) {
                System.arraycopy(queue, 0, newArray, 0, queue.size - 1)
            } else {
                System.arraycopy(queue, front, newArray, 0, tempIndex)
                System.arraycopy(queue, 0, newArray, tempIndex, back)
            }
            queue = newArray
            front = 0
            back = numItems
        }
        queue[back] = employee
        if(back < queue.size - 1) {
            back++
        } else {
            back = 0
        }
    }

    fun dequeue(): Employee? {
        if(isEmpty()) {
            throw NoSuchElementException()
        }
        val item = queue[front]
        queue[front] = null
        ++front
        if(size() == 0) {
            front = 0
            back = 0
        } else if(front == queue.size) {
            front = 0
        }
        return item
    }

    fun isEmpty(): Boolean = size() == 0
    fun size(): Int = if(front <= back) back - front else back - front + queue.size
    fun printAll() {
        println("Front >>> $front =========== back $back =========== capacity >>>> ${queue.size}")
        if(front <= back) {
            for (i in front until back) {
                println("$i >>>> ${queue[i]}")
            }
        } else {
            for (i in front until queue.size) {
                println("$i >>>> ${queue[i]}")
            }

            for (i in 0 until front) {
                println("$i >>>> ${queue[i]}")
            }
        }
    }
}