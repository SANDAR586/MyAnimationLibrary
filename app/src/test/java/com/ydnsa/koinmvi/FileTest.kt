package com.ydnsa.koinmvi

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main() {
    printLength(null)

}

fun printLength(str: String?) {
    str.let{
    println("it is not null")
    }?:{
        println("it is null")
    }
}

suspend fun doIndependentWork() = supervisorScope {
    launch {
        throw Exception("Failure!")
    }
    launch {
        println("Still runs despite failure")
    }
}