package com.tuckz.guilds.database

import androidx.room.*

@Dao
interface MessageDao {
    @Query("SELECT * FROM message")
    fun getAll(): List<Message>

    @Insert
    fun insertAll(vararg message: Message)

    @Delete
    fun delete(message: Message)
}