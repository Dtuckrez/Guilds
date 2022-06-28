package com.tuckz.guilds.database.user

import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM user")

    @Insert
    fun insertAll(vararg user: User)
}