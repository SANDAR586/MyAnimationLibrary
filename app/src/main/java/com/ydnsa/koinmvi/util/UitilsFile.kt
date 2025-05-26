@file:JvmName("ExtensionsKt")

package com.ydnsa.koinmvi.util

import java.time.*
import java.time.format.*

val fomatter = DateTimeFormatter.ofPattern("dd MMM yyyy")
        .withZone(ZoneId.systemDefault())

fun Instant.getDate() : String
{
    return fomatter.format(this)
}

fun Long.getDate() : String
{
    try
    {
        val instant = Instant.ofEpochMilli(this)
        return fomatter.format(instant)
    }
    catch (e : Exception)
    {
        return "-------"
    }
}