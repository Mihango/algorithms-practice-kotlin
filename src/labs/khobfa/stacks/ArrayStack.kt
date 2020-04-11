package labs.khobfa.stacks

import labs.khobfa.lists.Employee
import java.util.*

fun main() {
    val jane = Employee("Jane", "Smith", 3)
    val job = Employee("Job", "Rhyan", 4)
    val mohammed = Employee("Mohamed", "Yusuf", 5)
    val rhyan = Employee("Rhyan", "Jimmy", 6)

    val stack = ArrayStack(4)
    // push
    println("Stack size >>>>> ${stack.getSize()}")
    stack.push(jane)
    stack.push(job)
    println("Stack size >>>>> ${stack.getSize()}")
    println("Stack peek >>>>> ${stack.peek()}")
    println()
    stack.push(mohammed)
    stack.printAll()
    println()
    println("Stack pop >>>>> ${stack.pop()}")
    println()
    stack.push(rhyan)
    stack.printAll()


}

class ArrayStack(private val capacity: Int) {

    private var stack: Array<Employee?> = arrayOfNulls(capacity)
    private var top: Int = 0

    fun push(employee: Employee) {
        if(top == stack.size) {
            val newArray = Array(2 * stack.size) { i ->
                stack[i]
            }
            stack = newArray
        }
        stack[top++] = employee
    }

    @Throws(EmptyStackException::class)
    fun pop(): Employee? {
        if(!isEmpty()) {
            val employee = stack[--top]
            stack[top] = null
            // can recreate the array if the empty spacetop != 0 is big
            return employee
        }
        throw EmptyStackException()
    }

    @Throws(EmptyStackException::class)
    fun peek(): Employee? {
        if(!isEmpty()) {
            return stack[top-1]
        }
        throw EmptyStackException()
    }

    fun printAll() {
        for(i in top -1 downTo  0) {
            println("$i ====>>>>>>> ${stack[i]}")
        }
    }

    fun getSize(): Int = top
    fun isEmpty(): Boolean = top == 0
}