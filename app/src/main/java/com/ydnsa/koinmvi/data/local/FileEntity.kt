package com.ydnsa.koinmvi.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FileEntity(
    @PrimaryKey val uid:Int,
    @ColumnInfo(name="first_name") val folderName:String,// user first name
    @ColumnInfo(name="file_location") val fileLocation:String
)