package com.ydnsa.koinmvi.data.local

import androidx.room.*

@Database(entities = [UserEnitity::class , FileEntity::class] , version = 1)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun userDao() : UserDao
    abstract fun fileDao() : FileDao
}