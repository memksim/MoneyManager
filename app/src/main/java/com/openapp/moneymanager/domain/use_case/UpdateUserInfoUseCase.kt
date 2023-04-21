package com.openapp.moneymanager.domain.use_case

import com.openapp.moneymanager.base.data.repository.RemoteUserRepository
import com.openapp.moneymanager.base.domain.use_case.UpdateUserUseCase
import com.openapp.moneymanager.data.model.User
import com.openapp.moneymanager.utils.consts.SUCCESS_MESSAGE
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class UpdateUserInfoUseCase(
    private val remoteRepository: RemoteUserRepository
) : UpdateUserUseCase {

    override suspend fun execute(
        user: User,
        dispatcher: CoroutineDispatcher
    ): Flow<String> = flow {
        withContext(dispatcher) {
            try {
                remoteRepository.updateUserInfo(user = user)

                emit(SUCCESS_MESSAGE)
            } catch (e: Exception) {
                //todo throw custom exception
            }
        }
    }

}