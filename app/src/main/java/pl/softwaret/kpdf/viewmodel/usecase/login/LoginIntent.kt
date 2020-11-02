package pl.softwaret.kpdf.viewmodel.usecase.login

import pl.softwaret.kpdf.viewmodel.base.BaseIntent

sealed class LoginIntent : BaseIntent() {
    object ViewReady : LoginIntent()
}