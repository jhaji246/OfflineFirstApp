package com.avi.offlinefirstapp.domain.usecase

import com.avi.offlinefirstapp.domain.model.User
import com.avi.offlinefirstapp.domain.repository.UserRepository

class GetUsersUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(): List<User> {
        return userRepository.getUsers()
    }
}