package com.maxwell.nlpcpod.di

import com.maxwell.nlpcpod.domain.use_case.validator.LoginFormValidation
import com.maxwell.nlpcpod.domain.use_case.validator.SignupFormValidation
import com.maxwell.nlpcpod.domain.use_case.validator.ValidateEmail
import com.maxwell.nlpcpod.domain.use_case.validator.ValidateInput
import com.maxwell.nlpcpod.domain.use_case.validator.ValidatePassword
import com.maxwell.nlpcpod.domain.use_case.validator.ValidatePhoneNumber
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideValidateEmail() = ValidateEmail()


    @Provides
    @Singleton
    fun provideLoginValidation(validateEmail: ValidateEmail) =
        LoginFormValidation(
            validateEmail = validateEmail, validatePassword = ValidatePassword()
        )


    @Provides
    @Singleton
    fun provideSignUpValidation(validateEmail: ValidateEmail) =
        SignupFormValidation(
            validateEmail = validateEmail,
            validatePassword = ValidatePassword(),
            validateFullname = ValidateInput(),
            validatePhoneNumber = ValidatePhoneNumber()
        )
}