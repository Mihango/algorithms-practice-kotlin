package labs.khobfa.hash_tables

import labs.khobfa.lists.Employee

fun main() {
    val hashTable = LinearHashTable()

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

/**
 * Update on simple has table that solves problem of collision using Linear probing
 */
class LinearHashTable {
    val data = arrayOfNulls<Employee>(5)

    fun put(key: String, employee: Employee) {
        var hashedKey = hashKey(key)
        if(data[hashedKey] == null) {
            data[hashedKey] = employee
        } else {
            // linear probing - add 1 to hashed key until you have position with null
            // or stop
            hashedKey +=1
            if(hashedKey == data.size)
                hashedKey = 0

            while (hashedKey != data.size && data[hashedKey] != null) {
                hashedKey +=1
            }

            if(data[hashedKey] != null) {
                println("Position already has data")
            } else {
                data[hashedKey] = employee
            }
        }
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