package com.ydnsa.koinmvi.data.local

import android.content.*
import java.io.*

class LocalAccessHelper(val context : Context)
{

    fun createFile(fileName : String , content : String) : File
    {
        val file = File(context.filesDir , fileName)
        file.writeText(content)
        return file
    }
}
