package labs.khobfa.hash_tables

import labs.khobfa.lists.Employee
import java.util.*
import java.util.function.Consumer
import kotlin.collections.ArrayList

fun main() {
    val array: Array<ArrayList<String?>?> = arrayOfNulls<ArrayList<String?>?>(5)
    for (i in 0..4) {
        array[i] = ArrayList()
        array[i]?.add("Item $i")
        if (i % 2 == 0) {
            array[i]?.add("Item 2 >>>> $i")
        } else {
            array[i]?.add("Item 3 >>>> $i")
        }
    }
    for (data in array) {
        data?.forEach{ println(it) }
    }
}

class ChainedHashTable {



    data class StoredEmployee(val key: String, val employee: Employee)

    private var data: LinkedList<StoredEmployee> = LinkedList<StoredEmployee>()

    private fun hashKey(key: String): Int {
        return key.length % data.size
    }
}