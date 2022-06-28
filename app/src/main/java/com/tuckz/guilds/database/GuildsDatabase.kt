package com.tuckz.guilds.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tuckz.guilds.data.adventure.Adventure
import com.tuckz.guilds.database.user.User
import com.tuckz.guilds.database.user.UserDao

@Database(entities = [Message::class, User::class],  version = 1, exportSchema = false)
public abstract class GuildsDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
    abstract fun userDao(): UserDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: GuildsDatabase? = null

        fun getDatabase(context: Application?): GuildsDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context!!.applicationContext,
                    GuildsDatabase::class.java,
                    "guild_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}