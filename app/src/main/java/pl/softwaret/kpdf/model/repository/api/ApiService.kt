package pl.softwaret.kpdf.model.repository.api

import pl.softwaret.kpdf.model.repository.api.entity.LoginResponse
import pl.softwaret.kpdf.util.`try`.Try

interface ApiService {

    suspend fun loginUser(login: String, password: String): Try<LoginResponse, Unit>
}