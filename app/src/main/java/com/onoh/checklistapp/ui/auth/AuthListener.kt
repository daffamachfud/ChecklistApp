package com.onoh.checklistapp.ui.auth

import androidx.lifecycle.LiveData
import com.onoh.checklistapp.data.remote.response.LoginResponse

interface AuthListener {
    fun onStarted()
    fun onSuccess(loginResponse: LiveData<String>)
    fun onFailure(message:String)
}