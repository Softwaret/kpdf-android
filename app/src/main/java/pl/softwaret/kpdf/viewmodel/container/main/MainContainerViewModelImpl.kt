package pl.softwaret.kpdf.viewmodel.container.main

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
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
        relay.moveToLoginEvent.onEach { state.value = MainContainerState.LoginScreen }.launchIn(coroutineScope)
    }

    override suspend fun handleIntent(intent: MainContainerIntent) = when (intent) {
        MainContainerIntent.ViewReady -> state.value = MainContainerState.SplashScreen
    }
}