package pl.softwaret.core.model.interactor.usecase.login

import pl.softwaret.core.model.repository.login.LoginRepository

internal class LoginInteractorImpl(
    private val loginRepository: LoginRepository
) : LoginInteractor {

    override suspend fun loginUser(login: String, password: String) = loginRepository.loginUser(login, password)
}