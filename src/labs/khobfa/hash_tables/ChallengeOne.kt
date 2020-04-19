package labs.khobfa.hash_tables

import labs.khobfa.lists.Employee
import java.util.*
import java.util.function.Consumer
import kotlin.collections.HashMap
import kotlin.math.abs


fun main(){
    val nums = IntArray(10)
    val numsToAdd = intArrayOf(59382, 43, 6894, 500, 99, -58)

    for(i in numsToAdd.indices) {
        nums[hash(numsToAdd[i])] = numsToAdd[i]
    }


    println("================= Hashing ================")
    println("Array ---> ${nums.contentToString()}")
    println("================= remove duplicates ================")

    val employees = LinkedList<Employee>()
    employees.add(Employee("Jane", "Jones", 123))
    employees.add(Employee("John", "Doe", 5678))
    employees.add(Employee("Mike", "Wilson", 45))
    employees.add(Employee("Mary", "Smith", 5555))
    employees.add(Employee("John", "Doe", 5678))
    employees.add(Employee("Bill", "End", 3948))
    employees.add(Employee("Jane", "Jones", 123))

    val hashMap = HashMap<Int, Employee>()
    val dataToRemove = mutableListOf<Employee>()

    employees.listIterator().iterator().forEach{ e ->
        if(!hashMap.containsKey(e.id))
            hashMap[e.id] = e
        else {
            dataToRemove.add(e)
        }
    }

    dataToRemove.forEach { employees.remove(it) }
    employees.forEach { println(it) }
}

fun hash(key: Int): Int {
    return abs(key % 10)
}

fun removeDuplicates() {

}