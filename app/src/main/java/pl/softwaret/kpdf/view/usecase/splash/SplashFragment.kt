package pl.softwaret.kpdf.view.usecase.splash

import androidx.fragment.app.viewModels
import pl.softwaret.kpdf.R
import pl.softwaret.kpdf.view.base.BaseFragment
import pl.softwaret.kpdf.viewmodel.usecase.splash.SplashIntent
import pl.softwaret.kpdf.viewmodel.usecase.splash.SplashState
import pl.softwaret.kpdf.viewmodel.usecase.splash.SplashViewModel
import pl.softwaret.kpdf.viewmodel.usecase.splash.SplashViewModelImpl

class SplashFragment : BaseFragment<SplashIntent, SplashState, SplashViewModel>() {

    companion object {
        fun newInstance() = SplashFragment()
    }

    override val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()

    override fun obtainLayoutId() = R.layout.splash_fragment

    override suspend fun handleState(state: SplashState) = when (state) {
        SplashState.Initial -> offerToViewModel(SplashIntent.ViewReady)
        SplashState.UserLoggedIn -> {
            /* no-op */
        }
        SplashState.UserNotLoggedIn -> {
            /* no-op */
        }
    }
}