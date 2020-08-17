package com.sibi.bukuwarungtest.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sibi.bukuwarungtest.model.User

@Database(entities = [User::class],version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDao() : UserDao
}