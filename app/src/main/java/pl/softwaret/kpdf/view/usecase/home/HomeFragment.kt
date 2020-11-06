package pl.softwaret.kpdf.view.usecase.home

import androidx.fragment.app.viewModels
import pl.softwaret.kpdf.R
import pl.softwaret.kpdf.view.base.BaseFragment
import pl.softwaret.kpdf.viewmodel.usecase.home.HomeIntent
import pl.softwaret.kpdf.viewmodel.usecase.home.HomeState
import pl.softwaret.kpdf.viewmodel.usecase.home.HomeViewModel
import pl.softwaret.kpdf.viewmodel.usecase.home.HomeViewModelImpl

class HomeFragment : BaseFragment<HomeIntent, HomeState, HomeViewModel>() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    override val viewModel: HomeViewModel by viewModels<HomeViewModelImpl>()

    override fun obtainLayoutId() = R.layout.home_fragment

    override suspend fun handleState(state: HomeState) = when (state) {
        HomeState.Initial -> offerToViewModel(HomeIntent.ViewReady)
    }
}