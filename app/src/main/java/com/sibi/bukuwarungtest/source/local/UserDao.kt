package com.sibi.bukuwarungtest.source.local

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sibi.bukuwarungtest.model.User


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users:List<User>)

    @Query("select * from users")
    fun getAll() : DataSource.Factory<Int,User>
}