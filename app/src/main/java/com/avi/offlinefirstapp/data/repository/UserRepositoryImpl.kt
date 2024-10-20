package com.avi.offlinefirstapp.data.repository

import com.avi.offlinefirstapp.data.local.dao.UserDao
import com.avi.offlinefirstapp.data.local.entity.UserEntity
import com.avi.offlinefirstapp.data.remote.api.UserService
import com.avi.offlinefirstapp.domain.model.User
import com.avi.offlinefirstapp.domain.repository.UserRepository
import java.lang.Exception

class UserRepositoryImpl(
    private val userDao: UserDao,
    private val userService: UserService
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return try {
            val users = userService.getUsers()
            users.forEach { userDao.insertUser(it) }
            return users.map { User(it.id, it.name, it.email, it.imageUrl) }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getUserById(id: Int): User? {
        return userDao.getUsers().find { it.id == id }?.let {
            User(it.id, it.name, it.email, it.imageUrl)
        }
    }

    override suspend fun insertUser(user: User) {
        userDao.insertUser(UserEntity(user.id, user.name, user.email, user.imageUrl))
    }

}