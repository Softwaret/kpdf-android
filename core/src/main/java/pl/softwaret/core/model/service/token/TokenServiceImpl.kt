package pl.softwaret.core.model.service.token

import pl.softwaret.core.model.repository.token.TokenRepository

internal class TokenServiceImpl(private val tokenRepository: TokenRepository) : TokenService {

    override suspend fun isTokenSaved() =
        tokenRepository.obtainToken() != null && tokenRepository.obtainRefreshToken() != null
}