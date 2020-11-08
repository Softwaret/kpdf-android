package pl.softwaret.kpdf.viewmodel.usecase.home

import kotlinx.coroutines.flow.MutableStateFlow
import pl.softwaret.kpdf.viewmodel.base.BaseViewModel

class HomeViewModelImpl : BaseViewModel<HomeIntent, HomeState>(), HomeViewModel {
    override val state = MutableStateFlow<HomeState>(HomeState.Initial)

    override suspend fun handleIntent(intent: HomeIntent) = when (intent) {
        HomeIntent.ViewReady -> {
        }
    }
}