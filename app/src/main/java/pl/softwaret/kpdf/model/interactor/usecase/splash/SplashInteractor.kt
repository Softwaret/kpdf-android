package pl.softwaret.kpdf.model.interactor.usecase.splash

interface SplashInteractor {
    suspend fun isUserLoggedIn(): Boolean
}