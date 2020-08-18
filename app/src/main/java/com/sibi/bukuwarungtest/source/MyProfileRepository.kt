package com.sibi.bukuwarungtest.source

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.sibi.bukuwarungtest.model.MyProfile
import javax.inject.Inject

class MyProfileRepository @Inject constructor(private val sharedPreferences: SharedPreferences, private  val gson : Gson) {
    val myProfileMutableLiveData = MutableLiveData<MyProfile>()

    fun getUserProfile() {
        val myProfile = sharedPreferences.getString("myProfile", null)
        if(myProfile!=null) {
            val myProfileJson = gson.fromJson<MyProfile>(myProfile,MyProfile::class.java);
            myProfileMutableLiveData.postValue(myProfileJson)
        }
    }

    fun editProfile(myProfile: MyProfile) {
        val editor = sharedPreferences.edit()
        val myProfileJson = gson.toJson(myProfile)
        editor.putString("myProfile", myProfileJson)
        editor.apply()
    }
}