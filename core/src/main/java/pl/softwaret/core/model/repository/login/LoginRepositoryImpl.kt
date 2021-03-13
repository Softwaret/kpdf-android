package pl.softwaret.core.model.repository.login

import pl.softwaret.core.model.repository.api.ApiService
import pl.softwaret.core.util.extension.mapValue

class LoginRepositoryImpl(private val apiService: ApiService) : LoginRepository {

    override suspend fun loginUser(login: String, password: String) =
        apiService.loginUser(login, password)
            .mapValue { Unit }
}