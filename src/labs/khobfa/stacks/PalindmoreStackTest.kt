package labs.khobfa.stacks

import java.lang.StringBuilder
import java.util.*

fun main() {
    val raceCar = "Racecar"
    println("$raceCar >>>> is palindrome: ${isPalindromeIgnoreCaseAndSpecialChars(raceCar)}")

    val did = "I did, Did I?"
    println("$did >>>>  is palindrome: ${checkIfIsPalindrome(did)}")

    val hello = "Hello"
    println("$hello >>>>  is palindrome: ${isPalindromeIgnoreCaseAndSpecialChars(hello)}")
}

fun isPalindromeIgnoreCaseAndSpecialChars(item: String): Boolean {
    var isPalindrome = true

    val frontStack: Stack<Char> = Stack()
    val endStack: Stack<Char> = Stack()

    val itemCharArray = item.replace(" ", "").toCharArray()

    var count = 0
    for (i in itemCharArray.indices) {
        if (itemCharArray[i].isLetter()) {
            frontStack.push(itemCharArray[i])
            count++
        }
    }

    for (i in itemCharArray.size - 1 downTo 0) {
        if (itemCharArray[i].isLetter()) {
            endStack.push(itemCharArray[i])
        }
    }

    while (count > 0) {
        if (!frontStack.pop().equals(endStack.pop(), true)) {
            isPalindrome = false;
            break;
        }
        count -= 1
    }

    return isPalindrome
}

fun checkIfIsPalindrome(item: String): Boolean{
    val stack = LinkedList<Char>()
    val noSpaceBuilder = StringBuilder(item.length)

    val value = item.replace(" ", "").toLowerCase()

    value.filter { c -> c.isLetter() }
        .map { c ->
            noSpaceBuilder.append(c)
            stack.push(c)
        }

    val reverseBuilder = StringBuilder(stack.size)
    while(!stack.isEmpty()) {
        reverseBuilder.append(stack.pop())
    }

    return reverseBuilder.toString() == noSpaceBuilder.toString()
}