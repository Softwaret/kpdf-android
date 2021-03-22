package pl.softwaret.kpdf.viewmodel.usecase.home

import pl.softwaret.core.model.repository.entity.publication.Publication
import pl.softwaret.kpdf.viewmodel.base.BaseState

sealed class HomeState : BaseState() {
    object Initial : HomeState()
    class PublicationsList(val publications: List<Publication>) : HomeState()
}