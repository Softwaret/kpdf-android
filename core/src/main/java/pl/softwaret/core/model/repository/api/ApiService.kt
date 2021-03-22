package pl.softwaret.core.model.repository.api

import pl.softwaret.core.model.repository.api.entity.*
import pl.softwaret.core.util.`try`.Try

internal interface ApiService {
    suspend fun registerUser(login: String, password: String, name: String): Try<RegisterResponse, Unit>

    suspend fun loginUser(login: String, password: String): Try<LoginResponse, Unit>

    suspend fun refreshToken(login: String, refreshToken: String): Try<RefreshTokenResponse, Unit>

    suspend fun getPublications(): Try<GetPublicationsResponse, Unit>

    suspend fun getPublication(id: Int): Try<GetPublicationResponse, Unit>

    suspend fun uploadPublication(
        name: String,
        pdfBase64: String,
        description: String
    ): Try<UploadPublicationResponse, Unit>

    suspend fun updatePublication(publicationId: Int, pdfBase64: String): Try<UpdatePublicationResponse, Unit>

    suspend fun deletePublication(publicationId: Int): Try<DeletePublicationResponse, Unit>
}