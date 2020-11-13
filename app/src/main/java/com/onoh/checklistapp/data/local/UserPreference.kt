package com.onoh.checklistapp.data.local

import android.content.Context

class UserPreference(context: Context) {
    companion object{
        private const val PREFS_NAME = "user_pref"
        private const val isLogin = "isLogin"
        private const val token = "token"
    }

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setLogin(value:Boolean){
        val editor = preferences.edit()
        editor.putBoolean(isLogin,value)
        editor.apply()
    }

    fun getLogin():Boolean{
        return preferences.getBoolean(isLogin,false)
    }

    fun setToken(value:String){
        val editor = preferences.edit()
        editor.putString(token,value)
        editor.apply()
    }

    fun getToken():String?{
        return preferences.getString(token,"")
    }

}