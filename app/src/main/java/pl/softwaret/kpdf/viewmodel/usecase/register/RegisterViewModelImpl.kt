package pl.softwaret.kpdf.viewmodel.usecase.register

import kotlinx.coroutines.flow.MutableStateFlow
import org.kodein.di.instance
import pl.softwaret.kpdf.model.interactor.usecase.register.RegisterInteractor
import pl.softwaret.kpdf.util.extenstion.joinToUnit
import pl.softwaret.kpdf.util.extenstion.offer
import pl.softwaret.kpdf.util.extenstion.onError
import pl.softwaret.kpdf.util.extenstion.onValue
import pl.softwaret.kpdf.viewmodel.base.BaseViewModel
import pl.softwaret.kpdf.viewmodel.container.main.relay.MainContainerRelay

class RegisterViewModelImpl : BaseViewModel<RegisterIntent, RegisterState>(), RegisterViewModel {

    override val state = MutableStateFlow<RegisterState>(RegisterState.Initial)
    private val interactor: RegisterInteractor by instance()
    private val mainContainerRelay: MainContainerRelay by instance()

    override suspend fun handleIntent(intent: RegisterIntent) = when (intent) {
        RegisterIntent.ViewReady -> {
        }
        is RegisterIntent.RegisterUser -> {
            interactor.registerUser(intent.login, intent.password, intent.name)
                .onValue { mainContainerRelay.moveToLoginEvent.offer() }
                .onError { state.value = RegisterState.RegisterError }
                .joinToUnit()
        }
    }
}
