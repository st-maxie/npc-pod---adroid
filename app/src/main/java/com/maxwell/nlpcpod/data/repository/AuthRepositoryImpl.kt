package com.maxwell.nlpcpod.data.repository

import com.maxwell.nlpcpod.domain.repository.AuthRepository

class AuthRepositoryImpl:AuthRepository {
    override suspend fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun signup(email: String, password: String, fullName: String, phone: String) {
        TODO("Not yet implemented")
    }

    override suspend fun forgotPassword(email: String) {
        TODO("Not yet implemented")
    }
}