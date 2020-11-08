package pl.softwaret.kpdf.viewmodel.container.main

import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.kodein.di.instance
import pl.softwaret.kpdf.viewmodel.base.BaseViewModel
import pl.softwaret.kpdf.viewmodel.container.main.relay.MainContainerRelay

class MainContainerViewModelImpl : BaseViewModel<MainContainerIntent, MainContainerState>(), MainContainerViewModel {

    override val state = MutableStateFlow<MainContainerState>(MainContainerState.Initial)

    private val relay: MainContainerRelay by instance()

    init {
        bindToRelay()
    }

    private fun bindToRelay() {
        coroutineScope.launch { relay.moveToLoginEvent.consumeEach { state.value = MainContainerState.LoginScreen } }
        coroutineScope.launch { relay.moveToHomeEvent.consumeEach { state.value = MainContainerState.HomeScreen } }
        coroutineScope.launch {
            relay.moveToRegisterEvent.consumeEach {
                state.value = MainContainerState.RegisterScreen
            }
        }
    }

    override suspend fun handleIntent(intent: MainContainerIntent) = when (intent) {
        MainContainerIntent.ViewReady -> state.value = MainContainerState.SplashScreen
    }
}