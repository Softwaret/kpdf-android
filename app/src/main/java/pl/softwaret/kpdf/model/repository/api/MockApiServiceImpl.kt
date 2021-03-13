package pl.softwaret.kpdf.model.repository.api

import pl.softwaret.kpdf.model.repository.api.entity.*
import pl.softwaret.kpdf.model.repository.entity.publication.Publication
import pl.softwaret.kpdf.util.`try`.Try
import pl.softwaret.kpdf.util.extenstion.Error
import pl.softwaret.kpdf.util.extenstion.asValue

class MockApiServiceImpl : ApiService {

    private val publications = mutableSetOf<Publication>()
    private val users = mutableSetOf<User>()

    override suspend fun registerUser(login: String, password: String, name: String) =
        if (users.any { it.login == login }) {
            Try.Error
        } else {
            users.add(User(login, password, name))
            RegisterResponse().asValue()
        }

    override suspend fun loginUser(login: String, password: String) =
        if (users.any { it.login == login && it.password == password }) {
            LoginResponse("test-token_1234").asValue()
        } else {
            Try.Error
        }

    override suspend fun getPublication(id: Int) =
        publications.firstOrNull { it.id == id }
            ?.let { GetPublicationResponse(it.id, it.name, it.authorLogin, it.pdf, it.description) }
            ?.asValue() ?: Try.Error

    override suspend fun uploadPublication(
        name: String,
        pdfBase64: String,
        description: String
    ): Try<UploadPublicationResponse, Unit> {
        val newPublication = Publication(
            (publications.maxOfOrNull { it.id } ?: 0) + 1,
            name,
            users.first().login,
            pdfBase64,
            description
        )

        publications.add(newPublication)

        return UploadPublicationResponse(
            newPublication.id,
            newPublication.name,
            newPublication.authorLogin,
            newPublication.pdf,
            newPublication.description
        ).asValue()
    }

    override suspend fun updatePublication(publicationId: Int, pdfBase64: String) =
        if (publications.any { it.id == publicationId }) {
            val oldPub = publications.first { it.id == publicationId }
            publications.remove(oldPub)
            publications.add(oldPub.copy(pdf = pdfBase64))
            UpdatePublicationResponse().asValue()
        } else {
            Try.Error
        }

    override suspend fun deletePublication(publicationId: Int) = DeletePublicationResponse().asValue()

    private data class User(val login: String, val password: String, val name: String)
}