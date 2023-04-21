package com.openapp.moneymanager.base.domain.use_case

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

interface DeleteUserUseCase {
    suspend fun execute(dispatcher: CoroutineDispatcher = Dispatchers.IO): Flow<String>
}