package labs.khobfa.hash_tables

import labs.khobfa.lists.Employee

fun main() {
    val hashTable = SimpleHashTable1()

    val jane = Employee("Jane", "Smith", 3)
    val job = Employee("Job", "Rhyan", 4)
    val mohammed = Employee("Mohamed", "Yusuf", 5)
    val rhyan = Employee("Rhyan", "Jimmy", 6)

    //

    hashTable.put("jane", jane)
    hashTable.put("rhyan", job)
    hashTable.put("mohammed", mohammed)
    // adding jimmy will fail since jimmy and rhyan hashcode == 0
    // to solve this probing collision handling strategies --> Linear probing or chaining
    hashTable.put("jimmy", rhyan)

    hashTable.printAll()
}

class SimpleHashTable1 {
    val data = arrayOfNulls<Employee>(5)

    fun put(key: String, employee: Employee) {
        val hashedKey = hashKey(key)
        if(data[hashedKey] == null) {
            data[hashedKey] = employee
        } else {
            println("Position $hashedKey has data already ===>> ${data[hashedKey]?.firstName} " +
                    "${data[hashedKey]?.lastName}")
        }
    }

    fun get(key: String): Employee? {
        val hashedKey = hashKey(key)
        return data[hashedKey]
    }

    fun remove(key: String): Employee? {
        val hashedKey = hashKey(key)
        val employee = data[hashedKey]
        data[hashedKey] = null
        return employee
    }

    /**
     * Simple hash key returning modulus
     */
    private fun hashKey(key: String): Int {
        return key.length % data.size
    }

    fun printAll() {
        for(i in data.indices) {
            println("$i >>>>>>> ${data[i]}")
        }
    }
}