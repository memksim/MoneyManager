package com.openapp.moneymanager.domain.use_case

import com.openapp.moneymanager.base.data.repository.LocalUserRepository
import com.openapp.moneymanager.base.data.repository.RemoteUserRepository
import com.openapp.moneymanager.base.domain.use_case.LoadUserUseCase
import com.openapp.moneymanager.data.model.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class LoadUserInfoUseCase(
    private val localRepository: LocalUserRepository,
    private val remoteRepository: RemoteUserRepository
): LoadUserUseCase {

    override suspend fun execute(dispatcher: CoroutineDispatcher): Flow<User> = flow {
        withContext(dispatcher) {
            try {
                val token = async { localRepository.readUserToken() }

                val user = remoteRepository.readUserInfo(token.await())

                emit(user)
            } catch (e: Exception) {
                //todo throw custom exception
            }
        }
    }

}