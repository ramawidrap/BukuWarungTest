package com.sibi.bukuwarungtest.source

//import com.sibi.bukuwarungtest.source.local.UserDataSourceFactory
import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.sibi.bukuwarungtest.model.User
import com.sibi.bukuwarungtest.source.local.UserDao
import com.sibi.bukuwarungtest.source.network.UserService
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executor
import javax.inject.Inject

class UserRepository @Inject constructor(
    userDao: UserDao,
    userService: UserService,
    executor: Executor
) {
    private var page = 1
    private val boundaryCallback = object : PagedList.BoundaryCallback<User>() {
        @SuppressLint("CheckResult")
        override fun onZeroItemsLoaded() {
            super.onZeroItemsLoaded()
            userService.getUsers(page).observeOn(Schedulers.io()).subscribeOn(Schedulers.io())
                .subscribe({ response ->
                    userDao.insertUsers(response.data)
                }, { error ->
                    println(error)
                })
            page++
        }

        override fun onItemAtEndLoaded(itemAtEnd: User) {
            super.onItemAtEndLoaded(itemAtEnd)
        }


        @SuppressLint("CheckResult")
        override fun onItemAtFrontLoaded(itemAtFront: User) {
            super.onItemAtFrontLoaded(itemAtFront)
            userService.getUsers(page).observeOn(Schedulers.io()).subscribeOn(Schedulers.io())
                .subscribe({ response ->
                    userDao.insertUsers(response.data)
                },
                    { error ->
                        println(error)
                    })
            page++
        }
    }

    private val pagedList =
        PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(6)
            .setPageSize(6).build()
    val pagedListLiveData =
        LivePagedListBuilder(userDao.getAll(), pagedList).setFetchExecutor(executor)
            .setBoundaryCallback(boundaryCallback).build()


}