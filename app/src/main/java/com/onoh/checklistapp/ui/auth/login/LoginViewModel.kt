package com.onoh.checklistapp.ui.auth.login

import androidx.lifecycle.ViewModel
import com.onoh.checklistapp.data.remote.UserRepository
import com.onoh.checklistapp.ui.auth.AuthListener

class LoginViewModel : ViewModel() {

    private val authListener :AuthListener? = null

    fun onLogin(username:String,password:String){
        authListener?.onStarted()
        if(username.isNullOrEmpty()||password.isNullOrEmpty()){
            authListener?.onFailure("Username atau password salah")
            return
        }

        val loginResponse = UserRepository().userLogin(username!!, password!!)
        authListener?.onSuccess(loginResponse)
    }


}