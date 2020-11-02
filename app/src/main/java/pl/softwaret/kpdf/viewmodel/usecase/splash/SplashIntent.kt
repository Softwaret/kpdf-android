package pl.softwaret.kpdf.viewmodel.usecase.splash

import pl.softwaret.kpdf.viewmodel.base.BaseIntent

sealed class SplashIntent : BaseIntent() {
    object ViewReady : SplashIntent()
}