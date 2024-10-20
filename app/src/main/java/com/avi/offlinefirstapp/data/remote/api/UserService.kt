package com.avi.offlinefirstapp.data.remote.api

import com.avi.offlinefirstapp.data.local.entity.UserEntity
import retrofit2.http.GET

interface UserService {

    @GET("users")
    suspend fun getUsers() : List<UserEntity>
}