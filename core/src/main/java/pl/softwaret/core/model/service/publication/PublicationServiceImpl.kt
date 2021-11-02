package pl.softwaret.core.model.service.publication

import pl.softwaret.core.model.repository.publication.PublicationsRepository
import pl.softwaret.core.util.extension.joinToValue
import pl.softwaret.core.util.extension.mapValue

internal class PublicationServiceImpl(
    private val publicationsRepository: PublicationsRepository
) : PublicationService {
    override suspend fun obtainPublications() =
        publicationsRepository.getPublicationIds()
            .mapValue { fetchPublications(it) }

    private suspend fun fetchPublications(ids: List<Int>) =
        ids.mapNotNull {
            publicationsRepository.getPublication(it)
                .joinToValue { null }
        }
}