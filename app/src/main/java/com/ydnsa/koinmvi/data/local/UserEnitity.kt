package com.ydnsa.koinmvi.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEnitity(
    @PrimaryKey val uid :Int ,
    @ColumnInfo(name = "first_name") val firstName : String,
    @ColumnInfo(name = "second_name") val secondName : String
)