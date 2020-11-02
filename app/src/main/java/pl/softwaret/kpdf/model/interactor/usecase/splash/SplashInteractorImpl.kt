package pl.softwaret.kpdf.model.interactor.usecase.splash

import pl.softwaret.kpdf.model.service.token.TokenService

class SplashInteractorImpl(
        private val tokenService: TokenService
) : SplashInteractor {

    override suspend fun isUserLoggedIn() = tokenService.isValidTokenSaved()
}