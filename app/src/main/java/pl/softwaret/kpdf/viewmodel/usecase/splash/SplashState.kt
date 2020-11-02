package pl.softwaret.kpdf.viewmodel.usecase.splash

import pl.softwaret.kpdf.viewmodel.base.BaseState

sealed class SplashState : BaseState() {
    object Initial : SplashState()
    object UserLoggedIn : SplashState()
    object UserNotLoggedIn : SplashState()
}
