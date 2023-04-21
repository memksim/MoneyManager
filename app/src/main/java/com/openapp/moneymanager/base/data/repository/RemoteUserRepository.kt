package com.openapp.moneymanager.base.data.repository

import com.openapp.moneymanager.data.model.User

interface RemoteUserRepository {

    suspend fun createNewUser(user: User)

    suspend fun readUserInfo(token: String): User

    suspend fun updateUserInfo(user: User)

    suspend fun deleteUserInfo(token: String)

}