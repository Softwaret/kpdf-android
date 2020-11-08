package pl.softwaret.kpdf.model.interactor.usecase.register

import pl.softwaret.kpdf.util.`try`.Try

interface RegisterInteractor {
    suspend fun registerUser(login: String, password: String, name: String): Try<Unit, Unit>
}