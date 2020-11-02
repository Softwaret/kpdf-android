package pl.softwaret.kpdf.viewmodel.usecase.login

import kotlinx.coroutines.flow.MutableStateFlow
import pl.softwaret.kpdf.viewmodel.base.BaseViewModel

class LoginViewModelImpl : BaseViewModel<LoginIntent, LoginState>(), LoginViewModel {

    override val state = MutableStateFlow<LoginState>(LoginState.Initial)

    override suspend fun handleIntent(intent: LoginIntent) = when (intent) {
        LoginIntent.ViewReady -> {
        }
    }

}