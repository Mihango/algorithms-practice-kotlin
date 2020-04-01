package labs.khobfa.recursion

fun main() {
    println("Factorial of 5 = ${recursiveFactorial(5)}")
}

fun recursiveFactorial(num: Int): Int {
    if(num == 0) {
        return 1
    }

    return num * recursiveFactorial(num - 1)
}

fun iterativeFactorial(num: Int): Int {
    if(num ==0) {
        return 1;
    }

    var factorial = 1

    for(i in 1..num){
        factorial *= i;
    }

    return factorial
}
