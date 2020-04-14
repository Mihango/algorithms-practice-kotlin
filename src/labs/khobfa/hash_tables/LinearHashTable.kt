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
    hashTable.put("jimm", rhyan)
    println("================================= Print all data =================================")
    hashTable.printAll()

    println("================================= Get without probing =================================")
    /* returns jane since they have the same hashed key -- need to check if key is te same hence
    * one need to have saved the key
    */
    println("get jimm with initial get without linear probing ${hashTable.get("jimm")}")
    println("================================= Get with probing=================================")
    println("get jimm with initial get with linear probing ${hashTable.getLinear("jimm")}")
    println("================================= Remove with probing =================================")
    println("remove jane with initial get with linear probing ${hashTable.remove("jane")}")
}

/**
 * Update on simple has table that solves problem of collision using Linear probing
 */
class LinearHashTable {

    data class StoredEmployee(val key: String, val employee: Employee?)

    val data = arrayOfNulls<StoredEmployee>(5)

    fun put(key: String, value: Employee) {
        var hashedKey = hashKey(key)
        if(!isEmpty(hashedKey)) {
            val stopIndex = hashedKey
            if(hashedKey == data.size - 1) {
                hashedKey = 0
            } else {
                hashedKey++
            }
            while (!isEmpty(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % data.size
            }
        }

        if(isEmpty(hashedKey)) {
            data[hashedKey] = StoredEmployee(key, value)
        } else {
            println("Position $hashedKey has data already ===>> ${data[hashedKey]?.employee?.firstName} " +
                    "${data[hashedKey]?.employee?.lastName}")
        }
    }

    /** initial implementation
     * return data at hashed key which may be wrong since the hashed key may result to similar
     * values hence one needs to save the keys
     */
    @Deprecated("may return wong data", ReplaceWith("getLinear", "key"),
        DeprecationLevel.WARNING)
    fun get(key: String): Employee? {
        return data[hashKey(key)]?.employee
    }

    fun getLinear(key: String): Employee? {
        val hashedKey = findKey(key)
        return if(hashedKey != -1) {
            data[hashedKey]?.employee
        } else {
            null
        }
    }

    fun remove(key: String): Employee? {
        val hashedKey = findKey(key)
        return if(hashedKey != -1) {
            null
        } else {
            val emp = data[hashedKey]?.employee
            data[hashedKey] = null
            emp
        }
    }

    private fun findKey(key: String): Int {
        var hashedKey = hashKey(key);
        if(key == data[hashedKey]?.key) {
            return hashedKey
        } else {
            // loop through
            val stopKey = hashedKey
            if(hashedKey == data.size - 1) {
                hashedKey = 0
            } else {
                hashedKey++
            }

            while (data[hashedKey]?.key != key && hashedKey != stopKey) {
                hashedKey = (hashedKey + 1) % data.size
            }

            return if(data[hashedKey]?.key == key) {
                hashedKey
            } else {
                -1
            }
        }
    }

    private fun isEmpty(index: Int) = data[index] == null

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