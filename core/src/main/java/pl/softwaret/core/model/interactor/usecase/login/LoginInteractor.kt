package pl.softwaret.core.model.interactor.usecase.login

import pl.softwaret.core.util.`try`.Try

interface LoginInteractor {

    suspend fun loginUser(login: String, password: String): Try<Unit, Unit>
}