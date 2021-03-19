package pl.softwaret.core.model.repository.token

internal interface TokenRepository {

    suspend fun obtainToken(): String?

    suspend fun saveToken(token: String)

    suspend fun obtainRefreshToken(): String?

    suspend fun saveRefreshToken(refreshToken: String)
}