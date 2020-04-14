package labs.khobfa.arrays

import labs.khobfa.sort.swap

fun main() {
//    val data = intArrayOf(9,8,6,5,1,-2)
//    var j = 0
//    println("array[2++] =>>>> ${data[++j]}")

    // copy arrays
//    val datCopy = IntArray(3)
//    System.arraycopy(data, 2, datCopy, 1, 0)
//    println("Copies Data >>>> ${datCopy.contentToString()} ")

    println("Copies Data >>>> ${missingNumber(intArrayOf(3, 0, 1, 2, 5))} ")
}

fun missingNumber2(nums: IntArray): Int {
    nums.sort()

    println("Sorted array: ${nums.contentToString()}")
    if (nums[nums.size - 1] != nums.size)
        return nums.size

    if (nums[0] != 0) {
        return 0
    }

    for (i in 1 until nums.size) {
        val expectedNum = nums[i - 1] + 1
        if (nums[i] != expectedNum)
            return expectedNum
    }

    return -1
}

fun missingNumber(nums: IntArray): Int {
    val d = HashMap<String, String>()
    return (nums.size * (nums.size + 1)) / 2 - nums.sum()
}