package pl.softwaret.kpdf.viewmodel.usecase.home

import pl.softwaret.kpdf.viewmodel.base.BaseState

sealed class HomeState : BaseState() {
    object Initial : HomeState()
}