package com.sibi.bukuwarungtest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.sibi.bukuwarungtest.model.User
import com.sibi.bukuwarungtest.source.UserRepository
import javax.inject.Inject

class ListUserViewModel @Inject constructor(private val userRepository: UserRepository)  : ViewModel() {
    fun getUsers() : LiveData<PagedList<User>> {
        return userRepository.pagedListLiveData
    }

    fun getTotalItems() : LiveData<Int> {
        return userRepository.total_items
    }
}