package com.maxwell.nlpcpod.di

import com.maxwell.nlpcpod.data.manager.ManagerImpl
import com.maxwell.nlpcpod.data.repository.AuthRepositoryImpl
import com.maxwell.nlpcpod.domain.manager.TokenManager
import com.maxwell.nlpcpod.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindPreference(managerImpl: ManagerImpl):TokenManager


}