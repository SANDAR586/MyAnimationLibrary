package com.ydnsa.koinmvi.data.local

import androidx.room.Insert
import androidx.room.Query

interface FileDao {
    @Insert
    fun insertFile(vararg fileEntity: FileEntity)


}