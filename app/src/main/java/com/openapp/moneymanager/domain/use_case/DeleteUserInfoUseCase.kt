package com.openapp.moneymanager.domain.use_case

import com.openapp.moneymanager.base.data.repository.LocalUserRepository
import com.openapp.moneymanager.base.data.repository.RemoteUserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class DeleteUserInfoUseCase(
    private val localRepository: LocalUserRepository,
    private val remoteRepository: RemoteUserRepository
) {

    suspend fun execute(
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) = withContext(dispatcher) {
        val token = async { localRepository.readUserToken() }
        localRepository.clearUserToken()
        remoteRepository.deleteUserInfo(token.await())
    }


}