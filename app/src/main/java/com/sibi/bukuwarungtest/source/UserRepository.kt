package com.sibi.bukuwarungtest.source

import android.annotation.SuppressLint
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.sibi.bukuwarungtest.model.User
import com.sibi.bukuwarungtest.source.local.AppDatabase
import com.sibi.bukuwarungtest.source.network.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executor
import javax.inject.Inject

class UserRepository @Inject constructor(db : AppDatabase, userService: UserService,executor: Executor)  {
    private var page =  1
    private val boundaryCallback = object : PagedList.BoundaryCallback<User>() {
        @SuppressLint("CheckResult")
        override fun onZeroItemsLoaded() {
            super.onZeroItemsLoaded()
            userService.getUsers(page).observeOn(Schedulers.io()).subscribeOn(Schedulers.io()).subscribe {response ->
                db.getUserDao().insertUsers(response.data)
            }
            page++
        }

        @SuppressLint("CheckResult")
        override fun onItemAtEndLoaded(itemAtEnd: User) {
            super.onItemAtEndLoaded(itemAtEnd)
            userService.getUsers(page).observeOn(Schedulers.io()).subscribeOn(Schedulers.io()).subscribe {response ->
                db.getUserDao().insertUsers(response.data)
            }
            page++
        }
    }
    private val pagedList =PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(10).setPageSize(6).build()
    val pagedListLiveData = LivePagedListBuilder(db.getUserDao().getAll(),pagedList).setFetchExecutor(executor).setBoundaryCallback(boundaryCallback).build()


}