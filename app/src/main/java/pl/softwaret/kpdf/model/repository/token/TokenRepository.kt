package pl.softwaret.kpdf.model.repository.token

interface TokenRepository {

    suspend fun obtainToken(): String?

    suspend fun saveToken(token: String)
}