package pl.softwaret.kpdf.viewmodel.usecase.home

import kotlinx.coroutines.flow.MutableStateFlow
import org.kodein.di.instance
import pl.softwaret.core.model.interactor.usecase.home.HomeInteractor
import pl.softwaret.kpdf.viewmodel.base.BaseViewModel
import pl.softwaret.kpdf.viewmodel.container.main.relay.MainContainerRelay

class HomeViewModelImpl : BaseViewModel<HomeIntent, HomeState>(), HomeViewModel {
    override val state = MutableStateFlow<HomeState>(HomeState.Initial)

    private val interactor: HomeInteractor by instance()
    private val mainContainerRelay: MainContainerRelay by instance()

    override suspend fun handleIntent(intent: HomeIntent) = when (intent) {
        HomeIntent.ViewReady -> {
            state.value = HomeState.PublicationsList(interactor.obtainPublications())
        }
    }
}