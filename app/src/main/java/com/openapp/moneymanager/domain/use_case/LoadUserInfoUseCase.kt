package com.openapp.moneymanager.domain.use_case

import com.openapp.moneymanager.base.data.repository.LocalUserRepository
import com.openapp.moneymanager.base.data.repository.RemoteUserRepository
import com.openapp.moneymanager.data.model.User
import kotlinx.coroutines.*

class LoadUserInfoUseCase(
    private val localRepository: LocalUserRepository,
    private val remoteRepository: RemoteUserRepository
) {

    suspend fun execute(
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ): User = withContext(dispatcher) {
        val token = async { localRepository.readUserToken() }
        remoteRepository.readUserInfo(token.await())
    }

}