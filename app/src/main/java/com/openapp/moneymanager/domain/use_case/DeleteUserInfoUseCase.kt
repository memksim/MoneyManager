package com.openapp.moneymanager.domain.use_case

import com.openapp.moneymanager.base.data.repository.LocalUserRepository
import com.openapp.moneymanager.base.data.repository.RemoteUserRepository
import com.openapp.moneymanager.base.domain.use_case.DeleteUserUseCase
import com.openapp.moneymanager.utils.consts.SUCCESS_MESSAGE
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class DeleteUserInfoUseCase(
    private val localRepository: LocalUserRepository,
    private val remoteRepository: RemoteUserRepository
): DeleteUserUseCase {

    override suspend fun execute(dispatcher: CoroutineDispatcher): Flow<String> = flow {
        withContext(dispatcher) {
            try {
                val token = async { localRepository.readUserToken() }

                remoteRepository.deleteUserInfo(token.await())

                localRepository.clearUserToken()

                emit(SUCCESS_MESSAGE)
            } catch (e: Exception) {
                //todo throw custom exception
            }
        }
    }

}