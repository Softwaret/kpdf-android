package pl.softwaret.core.model.interactor.usecase.home

import pl.softwaret.core.model.repository.entity.publication.Publication

interface HomeInteractor {
    suspend fun obtainPublications(): List<Publication>
}