package labs.khobfa.queue

import java.util.*

fun main() {
    val raceCar = "Racecar"
    println("$raceCar >>>> is palindrome: ${isPalindrome(raceCar)}")

    val did = "I did, Did I?"
    println("$did >>>>  is palindrome: ${isPalindrome(did)}")

    val hello = "Hello"
    println("$hello >>>>  is palindrome: ${isPalindrome(hello)}")
}

fun isPalindrome(item: String): Boolean{
    var isP = true
    val value = item.replace(" ", "").toLowerCase()
    val queue = LinkedList<Char>()
    val stack = LinkedList<Char>()

    for(i in value.indices) {
        if(value[i].isLetter()) {
            stack.push(value[i])
            queue.add(value[i])
        }
    }

    var i = stack.size
    while(i > 0) {
        if(stack.pop() != queue.remove()){
            isP = false
            break
        }
        --i
    }

    return isP
}