package pl.softwaret.core.model.repository.publication

import pl.softwaret.core.model.repository.entity.publication.Publication
import pl.softwaret.core.util.`try`.Try

internal interface PublicationsRepository {

    suspend fun getPublicationIds(): Try<List<Int>, Unit>

    suspend fun getPublication(id: Int): Try<Publication, Unit>

    suspend fun uploadPublication(name: String, pdfBase64: String, description: String): Try<Unit, Unit>

    suspend fun updatePublication(publicationId: Int, pdfBase64: String): Try<Unit, Unit>

    suspend fun deletePublication(publicationId: Int): Try<Unit, Unit>
}