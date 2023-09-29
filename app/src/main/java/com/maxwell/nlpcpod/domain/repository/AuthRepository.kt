package com.maxwell.nlpcpod.domain.repository

interface AuthRepository {

    suspend fun login(email:String,password:String)

    suspend fun signup(email:String,password:String,fullName:String,phone:String)

    suspend fun forgotPassword(email: String)




}