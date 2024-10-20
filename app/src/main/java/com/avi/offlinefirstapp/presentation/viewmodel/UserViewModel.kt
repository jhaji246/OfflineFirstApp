package com.avi.offlinefirstapp.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avi.offlinefirstapp.domain.model.User
import com.avi.offlinefirstapp.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.launch

class UserViewModel(private val getUsersUseCase: GetUsersUseCase): ViewModel() {

    val users = mutableStateListOf<User>()

    fun fetchUsers() {
        viewModelScope.launch {
            users.addAll(getUsersUseCase())
        }
    }
}