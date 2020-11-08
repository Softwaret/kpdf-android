package pl.softwaret.kpdf.viewmodel.usecase.home

import pl.softwaret.kpdf.viewmodel.base.BaseIntent

sealed class HomeIntent : BaseIntent() {
    object ViewReady : HomeIntent()
}