package pl.softwaret.core.model.service.token

internal interface TokenService {
    suspend fun isTokenSaved(): Boolean
}