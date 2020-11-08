package pl.softwaret.kpdf.viewmodel.container.main

import pl.softwaret.kpdf.viewmodel.base.BaseState

sealed class MainContainerState : BaseState() {
    object Initial : MainContainerState()
    object SplashScreen : MainContainerState()
    object LoginScreen : MainContainerState()
    object RegisterScreen : MainContainerState()
    object HomeScreen : MainContainerState()
}