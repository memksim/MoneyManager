package com.openapp.moneymanager.base.data.repository

interface LocalUserRepository {

    suspend fun writeUserToken(token: String)

    suspend fun readUserToken(): String

    suspend fun clearUserToken()

}