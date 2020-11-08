package pl.softwaret.kpdf.view.container.main

import androidx.activity.viewModels
import pl.softwaret.kpdf.R
import pl.softwaret.kpdf.view.base.BaseContainerActivity
import pl.softwaret.kpdf.view.usecase.home.HomeFragment
import pl.softwaret.kpdf.view.usecase.login.LoginFragment
import pl.softwaret.kpdf.view.usecase.register.RegisterFragment
import pl.softwaret.kpdf.view.usecase.splash.SplashFragment
import pl.softwaret.kpdf.viewmodel.container.main.MainContainerIntent
import pl.softwaret.kpdf.viewmodel.container.main.MainContainerState
import pl.softwaret.kpdf.viewmodel.container.main.MainContainerViewModel
import pl.softwaret.kpdf.viewmodel.container.main.MainContainerViewModelImpl

class MainActivity : BaseContainerActivity<MainContainerIntent, MainContainerState, MainContainerViewModel>() {

    override val viewModel: MainContainerViewModel by viewModels<MainContainerViewModelImpl>()

    override fun obtainLayoutId() = R.layout.main_activity

    override suspend fun handleState(state: MainContainerState) = when (state) {
        MainContainerState.Initial -> offerToViewModel(MainContainerIntent.ViewReady)
        MainContainerState.SplashScreen -> showFragment(SplashFragment.newInstance())
        MainContainerState.LoginScreen -> showFragment(LoginFragment.newInstance())
        MainContainerState.RegisterScreen -> pushFragment(RegisterFragment.newInstance())
        MainContainerState.HomeScreen -> showFragment(HomeFragment.newInstance())
    }
}