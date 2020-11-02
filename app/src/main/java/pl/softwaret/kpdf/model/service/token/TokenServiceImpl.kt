package pl.softwaret.kpdf.model.service.token

import pl.softwaret.kpdf.model.repository.token.TokenRepository

class TokenServiceImpl(private val tokenRepository: TokenRepository) : TokenService {

    // TODO(1 - Handle token refresh)
    override suspend fun isValidTokenSaved() = false
}