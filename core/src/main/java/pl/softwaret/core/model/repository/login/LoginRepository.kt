package pl.softwaret.core.model.repository.login

import pl.softwaret.core.util.`try`.Try


interface LoginRepository {

    suspend fun loginUser(login: String, password: String): Try<Unit, Unit>
}