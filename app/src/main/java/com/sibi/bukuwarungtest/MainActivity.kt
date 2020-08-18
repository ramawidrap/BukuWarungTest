package com.sibi.bukuwarungtest

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.sibi.bukuwarungtest.model.MyProfile
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myProfile = sharedPreferences.getString("myProfile",null)
        if(myProfile == null) {
            val editor = sharedPreferences.edit()
            val gson = Gson()
            val jsonObject = gson.toJson(MyProfile())
            editor.putString("myProfile", jsonObject)
            editor.apply()
        }
    }
}
