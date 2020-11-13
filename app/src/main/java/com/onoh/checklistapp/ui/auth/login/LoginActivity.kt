package com.onoh.checklistapp.ui.auth.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.onoh.checklistapp.R
import com.onoh.checklistapp.data.local.UserPreference
import com.onoh.checklistapp.ui.MainActivity
import com.onoh.checklistapp.ui.auth.AuthListener
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),AuthListener{

    val userPreference  = UserPreference(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[LoginViewModel::class.java]

        val username = et_login_username.text.toString()
        val password = et_login_password.text.toString()

        btn_login_submit.setOnClickListener{
            viewModel.onLogin(username,password)
        }
    }

    override fun onStarted() {
        TODO("Not yet implemented")
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this,{
            userPreference.setToken(it)
            userPreference.setLogin(true)
        })
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    override fun onFailure(message: String) {
        TODO("Not yet implemented")
    }
}
