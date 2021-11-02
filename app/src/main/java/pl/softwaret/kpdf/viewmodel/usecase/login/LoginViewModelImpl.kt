package pl.softwaret.kpdf.viewmodel.usecase.login

import kotlinx.coroutines.flow.MutableStateFlow
import org.kodein.di.instance
import pl.softwaret.core.model.interactor.usecase.login.LoginInteractor
import pl.softwaret.core.util.extension.joinToUnit
import pl.softwaret.core.util.extension.offer
import pl.softwaret.core.util.extension.onError
import pl.softwaret.core.util.extension.onValue
import pl.softwaret.kpdf.viewmodel.base.BaseViewModel
import pl.softwaret.kpdf.viewmodel.container.main.relay.MainContainerRelay

class LoginViewModelImpl : BaseViewModel<LoginIntent, LoginState>(), LoginViewModel {

    override val state = MutableStateFlow<LoginState>(LoginState.Initial)

    private val interactor: LoginInteractor by instance()
    private val mainContainerRelay: MainContainerRelay by instance()

    override suspend fun handleIntent(intent: LoginIntent) = when (intent) {
        LoginIntent.ViewReady -> {
            state.value = LoginState.Initial
        }
        LoginIntent.OnRegister -> {
            mainContainerRelay.moveToRegisterEvent.offer()
        }
        is LoginIntent.OnLogin ->
            interactor.loginUser(intent.login, intent.password)
                .onValue { mainContainerRelay.moveToHomeEvent.offer() }
                .onError { state.value = LoginState.CredentialsError }
                .joinToUnit()
    }

}