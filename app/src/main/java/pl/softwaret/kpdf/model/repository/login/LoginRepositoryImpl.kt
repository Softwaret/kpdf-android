package pl.softwaret.kpdf.model.repository.login

import pl.softwaret.kpdf.model.repository.api.ApiService
import pl.softwaret.kpdf.util.extenstion.mapValue

class LoginRepositoryImpl(private val apiService: ApiService) : LoginRepository {

    override suspend fun loginUser(login: String, password: String) =
        apiService.loginUser(login, password)
            .mapValue { Unit }
}