package pl.softwaret.core.model.interactor.usecase.register

import pl.softwaret.core.model.repository.api.ApiService
import pl.softwaret.core.model.repository.login.LoginRepository
import pl.softwaret.core.util.extension.flatMapValue
import pl.softwaret.core.util.extension.mapValue

internal class RegisterInteractorImpl(
    private val loginRepository: LoginRepository,
    private val apiService: ApiService
) : RegisterInteractor {

    override suspend fun registerUser(login: String, password: String, name: String) =
        apiService.registerUser(login, password, name)
            .flatMapValue { loginRepository.loginUser(login, password) }
            .mapValue { }
}