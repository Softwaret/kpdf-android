package pl.softwaret.core.model.service.token

interface TokenService {
    suspend fun isValidTokenSaved(): Boolean
}