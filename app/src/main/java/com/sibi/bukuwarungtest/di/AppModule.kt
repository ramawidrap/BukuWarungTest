package com.sibi.bukuwarungtest.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.google.gson.Gson
import com.sibi.bukuwarungtest.source.local.AppDatabase
import com.sibi.bukuwarungtest.source.local.UserDao
import com.sibi.bukuwarungtest.source.network.UserService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class AppModule {

    companion object {
        val BASE_URL = "https://reqres.in/api/"
    }

    @Singleton
    @Provides
    fun getExecutor() : Executor {
        return Executors.newFixedThreadPool(5)
    }

    @Singleton
    @Provides
    fun  provideDatabase(application: Application) : AppDatabase {
        return Room.databaseBuilder(application.applicationContext,AppDatabase::class.java,"UserDB").build()
    }

    @Singleton
    @Provides
    fun provideUserDao(appDatabase: AppDatabase) : UserDao {
        return appDatabase.getUserDao()
    }

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideUserService(retrofit: Retrofit) : UserService {
        return retrofit.create(UserService::class.java)
    }

    @Singleton
    @Provides
    fun provideSharedPref(app : Application) : SharedPreferences {
        return app.getSharedPreferences("profile", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideGson() : Gson {
        return Gson()
    }

}