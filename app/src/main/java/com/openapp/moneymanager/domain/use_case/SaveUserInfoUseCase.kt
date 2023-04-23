package com.openapp.moneymanager.domain.use_case

import com.openapp.moneymanager.base.data.repository.LocalUserRepository
import com.openapp.moneymanager.base.data.repository.RemoteUserRepository
import com.openapp.moneymanager.data.model.User
import com.openapp.moneymanager.utils.generateToken
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SaveUserInfoUseCase(
    private val localRepository: LocalUserRepository,
    private val remoteRepository: RemoteUserRepository
) {

    suspend fun execute(
        user: User,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) = withContext(dispatcher) {
        val token = generateToken()
        val userWithToken = user.copy(token = token)
        localRepository.writeUserToken(token = token)
        remoteRepository.createNewUser(user = userWithToken)
    }


}