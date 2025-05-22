package com.ydnsa.koinmvi

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main() {
    fizzBuzz()
   println("HELLEH".isPalindrome())
}
fun String.isPalindrome(): Boolean{
     val a=this.reversed()
    return this==this.reversed()
}

fun fizzBuzz(){
    for (i in  0 until 100){

        when{
            i%3==0 -> println("Fizz")
            i%5==0 -> println("Buzz")
            else -> println(i)
        }
    }

}

fun safePursing(input:String):Int?{
   return input.toIntOrNull()

}

fun wordFrequencies(words:List<String>):Map<String,Int>{
      return   words.groupBy { it }.mapValues { it.value.size }
}

fun sumEvenNumbers(list:List<Int>) : Int {
   return list.filter {it%2==0 }.sum()
}

