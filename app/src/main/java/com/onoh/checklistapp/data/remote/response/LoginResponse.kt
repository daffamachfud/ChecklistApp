package com.onoh.checklistapp.data.remote.response

data class LoginResponse(
    val data: LoginData? = null,
    val errorMessage: Any? = null,
    val message: String? = null,
    val statusCode: Int? = null
)

data class LoginData(
	val token: String? = null
)

