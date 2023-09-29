package com.maxwell.nlpcpod.ui.screen.auth.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.maxwell.nlpcpod.domain.use_case.validator.LoginFormValidation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginFormValidation: LoginFormValidation
) : ViewModel() {

    val tag=LoginViewModel::class.java.simpleName
    var state by mutableStateOf(LoginState())
        private set

    fun onEvent(loginEvent: LoginEvent) {

        when (loginEvent) {
            is LoginEvent.OnEmailChange -> state = state.copy(email = loginEvent.email)

            is LoginEvent.OnPasswordChange -> state = state.copy(password = loginEvent.password)

            is LoginEvent.OnSubmit -> if (validateForm()) login()
        } }


    private fun validateForm(): Boolean {
       state = state.copy(emailErrorMessage =null, passwordErrorMessage = null)

        val emailResult = loginFormValidation.validateEmail(state.email)
        val passwordResult = loginFormValidation.validatePassword(state.password)

        if (!emailResult.valid) state = state.copy(emailErrorMessage = emailResult.message)
        if (!passwordResult.valid) state = state.copy(passwordErrorMessage = passwordResult.message)

        return emailResult.valid && passwordResult.valid
    }

    private fun login() {

    }

}