package pl.softwaret.kpdf.model.interactor.usecase.login

import pl.softwaret.kpdf.util.`try`.Try

interface LoginInteractor {

    suspend fun loginUser(login: String, password: String): Try<Unit, Unit>
}