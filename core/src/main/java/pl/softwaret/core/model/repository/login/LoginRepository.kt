package pl.softwaret.core.model.repository.login

import pl.softwaret.core.util.`try`.Try


internal interface LoginRepository {

    suspend fun loginUser(login: String, password: String): Try<Unit, Unit>
}