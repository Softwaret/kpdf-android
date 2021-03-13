package pl.softwaret.core.model.interactor.usecase.register

import pl.softwaret.core.model.repository.api.ApiService
import pl.softwaret.core.util.extension.mapValue

class RegisterInteractorImpl(
    private val apiService: ApiService
) : RegisterInteractor {

    override suspend fun registerUser(login: String, password: String, name: String) =
        apiService.registerUser(login, password, name)
            .mapValue { }
}