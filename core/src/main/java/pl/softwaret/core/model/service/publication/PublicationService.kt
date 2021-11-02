package pl.softwaret.core.model.service.publication

import pl.softwaret.core.model.repository.entity.publication.Publication
import pl.softwaret.core.util.`try`.Try

internal interface PublicationService {
    suspend fun obtainPublications(): Try<List<Publication>, Unit>
}