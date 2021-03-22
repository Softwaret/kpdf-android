package pl.softwaret.core.model.interactor.usecase.home

import pl.softwaret.core.model.service.publication.PublicationService
import pl.softwaret.core.util.extension.joinToValue

internal class HomeInteractorImpl(
    private val publicationService: PublicationService
) : HomeInteractor {

    override suspend fun obtainPublications() =
        publicationService.obtainPublications()
            .joinToValue { emptyList() }
}