//package com.sibi.bukuwarungtest.source.local
//
//import android.annotation.SuppressLint
//import androidx.paging.PositionalDataSource
//import com.sibi.bukuwarungtest.model.User
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.schedulers.Schedulers
//import javax.inject.Inject
////
//class UserDataSource @Inject constructor (private val userDao: UserDao) : PositionalDataSource<User>() {
//    @SuppressLint("CheckResult")
//    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<User>) {
//        println("loadrange")
//        userDao.getAll(params.loadSize,params.startPosition).observeOn(Schedulers.io()).subscribeOn(Schedulers.io()).subscribe {users ->
//            callback.onResult(users)
//        }
////        println("finish load range")
//    }
//
//
//    @SuppressLint("CheckResult")
//    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<User>) {
//        println("loadinitial")
//        userDao.getAll(params.requestedLoadSize,0).observeOn(Schedulers.io()).subscribeOn(Schedulers.io()).subscribe {users ->
//            callback.onResult(users,0)
//        }
//        println("finish load initial")
//    }
////
////
////}