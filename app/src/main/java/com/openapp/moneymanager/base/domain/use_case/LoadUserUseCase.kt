package com.openapp.moneymanager.base.domain.use_case

import com.openapp.moneymanager.data.model.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

interface LoadUserUseCase {
    suspend fun execute(dispatcher: CoroutineDispatcher = Dispatchers.IO): Flow<User>
}