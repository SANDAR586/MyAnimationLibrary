package com.ydnsa.koinmvi.data.local

import androidx.room.*

@Dao
interface FileDao
{
    @Insert
    fun insertFile(vararg fileEntity : FileEntity)

    @Query("Select * from FileEntity")
    fun getAllFiles() : List<FileEntity>

}