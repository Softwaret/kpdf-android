package pl.softwaret.kpdf.model.repository.api

import pl.softwaret.kpdf.model.repository.api.entity.LoginResponse
import pl.softwaret.kpdf.model.repository.api.entity.RegisterResponse
import pl.softwaret.kpdf.util.`try`.Try

interface ApiService {

    suspend fun registerUser(login: String, password: String, name: String): Try<RegisterResponse, Unit>
    suspend fun loginUser(login: String, password: String): Try<LoginResponse, Unit>
}