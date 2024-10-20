package com.avi.offlinefirstapp.domain.repository

import com.avi.offlinefirstapp.domain.model.User

interface UserRepository {

    suspend fun getUsers(): List<User>
    suspend fun getUserById(id: Int): User?
    suspend fun insertUser(user: User)
}