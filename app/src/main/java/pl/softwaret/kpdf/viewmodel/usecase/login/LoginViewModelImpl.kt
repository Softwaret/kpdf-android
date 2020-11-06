package pl.softwaret.kpdf.viewmodel.usecase.login

import kotlinx.coroutines.flow.MutableStateFlow
import org.kodein.di.instance
import pl.softwaret.kpdf.model.interactor.usecase.login.LoginInteractor
import pl.softwaret.kpdf.util.`typealias`.sendSignal
import pl.softwaret.kpdf.util.extenstion.isValue
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
            mainContainerRelay.moveToRegisterEvent.sendSignal()
        }
        is LoginIntent.OnLogin -> if (interactor.loginUser(intent.login, intent.password).isValue) {
            mainContainerRelay.moveToHomeEvent.sendSignal()
        } else {
            state.value = LoginState.CredentialsError
        }
    }

}