package com.ydnsa.koinmvi.data.local

import androidx.room.*

@Entity
data class FileEntity(
        @PrimaryKey val uid : String ,
        @ColumnInfo(name = "first_name") val folderName : String ,// user first name
        @ColumnInfo(name = "file_location") val fileLocation : String ,
        @ColumnInfo(name = "title") val title : String ,
        @ColumnInfo(name = "content") val content : String ,
        @ColumnInfo(name = "timestamp") val timestamp : Long ,
                     )