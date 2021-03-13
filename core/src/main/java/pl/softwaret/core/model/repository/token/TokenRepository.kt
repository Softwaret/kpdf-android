package pl.softwaret.core.model.repository.token

interface TokenRepository {

    suspend fun obtainToken(): String?

    suspend fun saveToken(token: String)
}