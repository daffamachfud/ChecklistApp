package com.onoh.checklistapp.network

import com.onoh.checklistapp.data.remote.request.LoginRequest
import com.onoh.checklistapp.data.remote.request.RegisterRequest
import com.onoh.checklistapp.data.remote.response.ItemResponse
import com.onoh.checklistapp.data.remote.response.LoginResponse
import com.onoh.checklistapp.data.remote.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("register")
    fun register(@Body body:RegisterRequest):Call<RegisterResponse>

    @POST("login")
    fun login(@Body body:LoginRequest):Call<LoginResponse>

    @GET("checklist")
    fun getChecklist(@Header("Authorization") token:String):Call<ItemResponse>

}