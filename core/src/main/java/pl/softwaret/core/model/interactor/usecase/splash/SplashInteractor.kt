package pl.softwaret.core.model.interactor.usecase.splash

interface SplashInteractor {
    suspend fun isUserLoggedIn(): Boolean
}