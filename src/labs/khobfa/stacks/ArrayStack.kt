package labs.khobfa.stacks

import labs.khobfa.lists.Employee

fun main() {
    val jane = Employee("Jane", "Smith", 3)
    val job = Employee("Job", "Rhyan", 4)
    val mohammed = Employee("Mohamed", "Yusuf", 5)
    val rhyan = Employee("Rhyan", "Jimmy", 6)

    // push

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
        stack[++top] = employee
    }

    fun pop(): Employee? {
        if(top != 0) {
            return stack[--top]
        }
        return null
    }

    fun peek(): Employee? {
        if(top != 0) {
            return stack[top - 1]
        }
        return null
    }

    fun printAll() {
        for(i in top -1 downTo  0) {
            println("$i ====>>>>>>> ${stack[i]}")
        }
    }
}