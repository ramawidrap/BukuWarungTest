package com.sibi.bukuwarungtest.source.network

import com.sibi.bukuwarungtest.source.network.response.UserResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("users")
    fun  getUsers(@Query("page") page:Int) : Flowable<UserResponse>
}