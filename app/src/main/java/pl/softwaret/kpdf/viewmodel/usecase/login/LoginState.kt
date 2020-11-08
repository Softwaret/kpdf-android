package pl.softwaret.kpdf.viewmodel.usecase.login

import pl.softwaret.kpdf.viewmodel.base.BaseState

sealed class LoginState : BaseState() {
    object Initial : LoginState()
    object CredentialsError : LoginState()
}