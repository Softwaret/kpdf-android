package pl.softwaret.core.model.repository.login

import pl.softwaret.core.model.repository.api.ApiService
import pl.softwaret.core.model.repository.token.TokenRepository
import pl.softwaret.core.util.extension.mapValue
import pl.softwaret.core.util.extension.onValue

internal class LoginRepositoryImpl(
    private val apiService: ApiService,
    private val tokenRepository: TokenRepository
) : LoginRepository {

    override suspend fun loginUser(login: String, password: String) =
        apiService.loginUser(login, password)
            .onValue { saveTokens(it.token, it.refreshToken) }
            .mapValue { }

    private suspend fun saveTokens(token: String, refreshToken: String) {
        tokenRepository.saveToken(token)
        tokenRepository.saveRefreshToken(refreshToken)
    }
}