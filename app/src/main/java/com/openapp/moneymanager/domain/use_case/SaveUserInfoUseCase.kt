package com.openapp.moneymanager.domain.use_case

import com.openapp.moneymanager.base.data.repository.LocalUserRepository
import com.openapp.moneymanager.base.data.repository.RemoteUserRepository
import com.openapp.moneymanager.base.domain.use_case.SaveUserUseCase
import com.openapp.moneymanager.data.model.User
import com.openapp.moneymanager.utils.consts.SUCCESS_MESSAGE
import com.openapp.moneymanager.utils.generateToken
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class SaveUserInfoUseCase(
    private val localRepository: LocalUserRepository,
    private val remoteRepository: RemoteUserRepository
) : SaveUserUseCase {

    override suspend fun execute(
        user: User,
        dispatcher: CoroutineDispatcher
    ): Flow<String> = flow {
        withContext(dispatcher) {
            val token = generateToken()
            val userWithToken = user.copy(token = token)

            try {
                localRepository.writeUserToken(token = token)

                remoteRepository.createNewUser(user = userWithToken)
            } catch (e: Exception) {
                //todo throw custom exception
            }

            emit(SUCCESS_MESSAGE)
        }
    }

}