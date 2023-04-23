package com.openapp.moneymanager.domain.use_case

import com.openapp.moneymanager.base.data.repository.RemoteUserRepository
import com.openapp.moneymanager.data.model.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateUserInfoUseCase(
    private val remoteRepository: RemoteUserRepository
) {

    suspend fun execute(
        user: User,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) = withContext(dispatcher) {
        remoteRepository.updateUserInfo(user = user)
    }


}