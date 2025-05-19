package com.ydnsa.koinmvi.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FileDao {
    @Insert
    fun insertFile(vararg fileEntity: FileEntity)


}