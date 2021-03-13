package pl.softwaret.kpdf.viewmodel.usecase.splash

import kotlinx.coroutines.flow.MutableStateFlow
import org.kodein.di.instance
import pl.softwaret.core.model.interactor.usecase.splash.SplashInteractor
import pl.softwaret.core.util.extension.offer
import pl.softwaret.kpdf.viewmodel.base.BaseViewModel
import pl.softwaret.kpdf.viewmodel.container.main.relay.MainContainerRelay

class SplashViewModelImpl : BaseViewModel<SplashIntent, SplashState>(), SplashViewModel {

    override val state = MutableStateFlow<SplashState>(SplashState.Initial)

    private val interactor: SplashInteractor by instance()
    private val mainContainerRelay: MainContainerRelay by instance()

    override suspend fun handleIntent(intent: SplashIntent) = when (intent) {
        SplashIntent.ViewReady -> when (isUserLoggedIn()) {
            true -> {
                state.value = SplashState.UserLoggedIn
                mainContainerRelay.moveToHomeEvent.offer()
            }
            false -> {
                state.value = SplashState.UserNotLoggedIn
                mainContainerRelay.moveToLoginEvent.offer()
            }
        }
    }

    private suspend fun isUserLoggedIn() = interactor.isUserLoggedIn()
}