package com.ydnsa.koinmvi

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main() {
    val list= listOf(1,2,3,4,5,6,7,8,976,44,33,22,11,44,66)
    println(sumEvenNumbers(list))

}

fun wordFrequencies(words:List<String>):Map<String,Int>{
      return   words.groupBy { it }.mapValues { it.value.size }


}

fun sumEvenNumbers(list:List<Int>) : Int {
   return list.filter {it%2==0 }.sum()
}

