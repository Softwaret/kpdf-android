package pl.softwaret.kpdf.model.service.token

interface TokenService {
    suspend fun isValidTokenSaved(): Boolean
}