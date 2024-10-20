package com.avi.offlinefirstapp.di

import com.avi.offlinefirstapp.data.local.dao.UserDao
import com.avi.offlinefirstapp.data.remote.api.UserService
import com.avi.offlinefirstapp.data.repository.UserRepositoryImpl
import com.avi.offlinefirstapp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideUserRepository(userDao: UserDao, userService: UserService): UserRepository {
        return UserRepositoryImpl(userDao, userService)
    }
}
