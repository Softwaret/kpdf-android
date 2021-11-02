package pl.softwaret.core.model.interactor.usecase.splash

import pl.softwaret.core.model.service.token.TokenService

internal class SplashInteractorImpl(
        private val tokenService: TokenService
) : SplashInteractor {

    override suspend fun isUserLoggedIn() = tokenService.isTokenSaved()
}