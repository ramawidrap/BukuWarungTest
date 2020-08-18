package com.sibi.bukuwarungtest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sibi.bukuwarungtest.model.MyProfile
import com.sibi.bukuwarungtest.source.MyProfileRepository
import javax.inject.Inject

class MyProfileViewModel @Inject constructor(private val myProfileRepository: MyProfileRepository) : ViewModel() {

    fun getMyProfile() : LiveData<MyProfile> {
        myProfileRepository.getUserProfile()
        return myProfileRepository.myProfileMutableLiveData
    }

    fun editProfile(myProfile: MyProfile) {
        myProfileRepository.editProfile(myProfile)
    }
}