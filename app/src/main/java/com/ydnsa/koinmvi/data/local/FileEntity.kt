package com.ydnsa.koinmvi.data.local

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class FileEntity(
    @PrimaryKey val uid:Int,
    @ColumnInfo val folderName:String,// user first name
    @ColumnInfo val fileLocation:String
)