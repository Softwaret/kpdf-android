package pl.softwaret.kpdf.model.interactor.usecase.login

import pl.softwaret.kpdf.model.repository.login.LoginRepository

class LoginInteractorImpl(
    private val loginRepository: LoginRepository
) : LoginInteractor {

    override suspend fun loginUser(login: String, password: String) =
        loginRepository.loginUser(login, password)
}