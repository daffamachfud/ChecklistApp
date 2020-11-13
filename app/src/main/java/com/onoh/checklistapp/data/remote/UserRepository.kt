package com.onoh.checklistapp.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onoh.checklistapp.data.remote.request.LoginRequest
import com.onoh.checklistapp.data.remote.request.RegisterRequest
import com.onoh.checklistapp.data.remote.response.DataItem
import com.onoh.checklistapp.data.remote.response.ItemResponse
import com.onoh.checklistapp.data.remote.response.LoginResponse
import com.onoh.checklistapp.data.remote.response.RegisterResponse
import com.onoh.checklistapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserRepository{
    fun userLogin(username:String,password:String): LiveData<String> {
        var body = LoginRequest(password,username)
        val loginResponse = MutableLiveData<String>()

        RetrofitClient.api().login(body).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if(response.isSuccessful){
                    loginResponse.value = response.body()?.data.toString()
                }else{
                    loginResponse.value = response.body()?.message.toString()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                loginResponse.value = t.message
            }
        })
        return loginResponse
    }

    fun userRegister(body:RegisterRequest) : LiveData<String>{
        val registerResponse = MutableLiveData<String>()

        RetrofitClient.api().register(body).enqueue(object:Callback<RegisterResponse>{
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if(response.isSuccessful){
                    registerResponse.value = response.body()?.message.toString()
                }else{
                    registerResponse.value = response.body()?.errorMessage.toString()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                registerResponse.value = t.toString()
            }
        })
        return registerResponse
    }

    fun getItem(token:String):LiveData<List<DataItem?>>{
        val item = MutableLiveData<List<DataItem?>>()
        RetrofitClient.api().getChecklist(token).enqueue(object:Callback<ItemResponse>{
            override fun onResponse(call: Call<ItemResponse>, response: Response<ItemResponse>) {
                if(response.isSuccessful){
                    item.value = response.body()?.data
                }
            }

            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                Log.d("onFailure", t.message.toString())
            }
        })
        return item
    }
}

