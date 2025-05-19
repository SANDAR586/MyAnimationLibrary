package com.ydnsa.koinmvi.data.local

import User
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao  {

    @Query("Select * from userenitity")
    fun getAllUser(): List<UserEnitity>

    @Query("SELECT * FROM userenitity WHERE first_name LIKE :first AND " +
            "second_name LIKE :last  LIMIT 1")
    fun findByName(first: String, last: String): UserEnitity

    @Insert
    fun insertAll(vararg users: UserEnitity)

    @Delete
    fun delete(user: UserEnitity)
}