package pl.softwaret.core.model.interactor.usecase.register

import pl.softwaret.core.util.`try`.Try


interface RegisterInteractor {
    suspend fun registerUser(login: String, password: String, name: String): Try<Unit, Unit>
}