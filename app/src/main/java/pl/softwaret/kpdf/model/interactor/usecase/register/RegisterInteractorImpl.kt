package pl.softwaret.kpdf.model.interactor.usecase.register

import pl.softwaret.kpdf.model.repository.api.ApiService
import pl.softwaret.kpdf.util.extenstion.mapValue

class RegisterInteractorImpl(
    private val apiService: ApiService
) : RegisterInteractor {

    override suspend fun registerUser(login: String, password: String, name: String) =
        apiService.registerUser(login, password, name)
            .mapValue { Unit }
}