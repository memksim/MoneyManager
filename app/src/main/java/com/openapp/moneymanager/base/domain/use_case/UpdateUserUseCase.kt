package com.openapp.moneymanager.base.domain.use_case

import com.openapp.moneymanager.data.model.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

interface UpdateUserUseCase {
    suspend fun execute(
        user: User,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ): Flow<String>
}