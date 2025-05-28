package com.ydnsa.koinmvi.data.local

import android.content.*
import android.util.*
import java.io.*
import java.time.*
import java.time.format.*

class LocalAccessHelper(val context : Context)
{

    fun writeFile(content : String) : File?
    {
        try
        {
            val filename = getTimestampFileName() + ".html"

            val file = File(context.filesDir , filename)
            context.openFileOutput(filename , Context.MODE_PRIVATE).use {
                it.write(content.toByteArray())
            }
            return file
        } catch (e : Exception)
        {
            Log.e("FileCreation" , "Error creating file" , e)
            throw e

        }
    }

    fun getTimestampFileName() : String
    {
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
            .withZone(ZoneId.systemDefault())
        Log.e("file" , formatter.format(Instant.now()))
        return formatter.format(Instant.now())
    }

    fun readFile(fileEntity : FileEntity) : String
    {
        val file = File(fileEntity.fileLocation)
        return file.readText()
    }

    fun getDisplayContent(htmlString : String) : String
    {
        val plainText = htmlString
            .replace(Regex("<[^>]*>") , "") // Remove all HTML tags
            .replace("\n" , "")             // Remove all newlines
            .trim()
        val limitedText = plainText
            .split(Regex("\\s+"))         // Split by any whitespace
            .take(5)                      // Take first 5 words
            .joinToString(" ")
        return limitedText
    }

}
