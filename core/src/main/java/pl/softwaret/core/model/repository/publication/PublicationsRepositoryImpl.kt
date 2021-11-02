package pl.softwaret.core.model.repository.publication

import pl.softwaret.core.model.repository.api.ApiService
import pl.softwaret.core.model.repository.api.entity.GetPublicationResponse
import pl.softwaret.core.model.repository.entity.publication.Publication
import pl.softwaret.core.util.extension.mapValue

internal class PublicationsRepositoryImpl(
    private val apiService: ApiService
) : PublicationsRepository {

    override suspend fun getPublicationIds() =
        apiService.getPublications()
            .mapValue { it.publicationIds }

    override suspend fun getPublication(id: Int) =
        apiService.getPublication(id)
            .mapValue { it.toPublication() }

    override suspend fun uploadPublication(name: String, pdfBase64: String, description: String) =
        apiService.uploadPublication(name, pdfBase64, description)
            .mapValue { }

    override suspend fun updatePublication(publicationId: Int, pdfBase64: String) =
        apiService.updatePublication(publicationId, pdfBase64)
            .mapValue { }

    override suspend fun deletePublication(publicationId: Int) =
        apiService.deletePublication(publicationId)
            .mapValue { }

    private fun GetPublicationResponse.toPublication() = Publication(
        id = id,
        name = name,
        authorLogin = authorLogin,
        pdf = pdf,
        description = description
    )
}