package pl.softwaret.kpdf.viewmodel.usecase.register

import pl.softwaret.kpdf.viewmodel.base.BaseIntent

sealed class RegisterIntent : BaseIntent() {
    object ViewReady : RegisterIntent()
}