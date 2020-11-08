package pl.softwaret.kpdf.model.repository.login

import pl.softwaret.kpdf.util.`try`.Try

interface LoginRepository {

    suspend fun loginUser(login: String, password: String): Try<Unit, Unit>
}