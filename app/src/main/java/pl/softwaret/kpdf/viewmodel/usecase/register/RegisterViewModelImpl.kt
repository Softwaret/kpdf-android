package pl.softwaret.kpdf.viewmodel.usecase.register

import kotlinx.coroutines.flow.MutableStateFlow
import pl.softwaret.kpdf.viewmodel.base.BaseViewModel

class RegisterViewModelImpl : BaseViewModel<RegisterIntent, RegisterState>(), RegisterViewModel {
    override val state = MutableStateFlow<RegisterState>(RegisterState.Initial)

    override suspend fun handleIntent(intent: RegisterIntent) = when (intent) {
        RegisterIntent.ViewReady -> {
        }
    }
}
