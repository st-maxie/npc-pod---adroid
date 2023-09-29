package com.maxwell.nlpcpod.ui.screen.auth.login

import com.maxwell.nlpcpod.utils.Response

data class LoginState(
    val email:String="",
    val password:String="",
    val emailErrorMessage:String?=null,
    val passwordErrorMessage:String?=null,
    val success: Boolean=false
)