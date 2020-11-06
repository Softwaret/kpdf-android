package pl.softwaret.kpdf.viewmodel.usecase.register

import pl.softwaret.kpdf.viewmodel.base.BaseState

sealed class RegisterState : BaseState() {
    object Initial : RegisterState()
}