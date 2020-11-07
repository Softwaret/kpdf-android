package pl.softwaret.kpdf.view.usecase.register

import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.register_fragment.*
import pl.softwaret.kpdf.R
import pl.softwaret.kpdf.view.base.BaseFragment
import pl.softwaret.kpdf.viewmodel.usecase.register.RegisterIntent
import pl.softwaret.kpdf.viewmodel.usecase.register.RegisterState
import pl.softwaret.kpdf.viewmodel.usecase.register.RegisterViewModel
import pl.softwaret.kpdf.viewmodel.usecase.register.RegisterViewModelImpl

class RegisterFragment : BaseFragment<RegisterIntent, RegisterState, RegisterViewModel>() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    override val viewModel: RegisterViewModel by viewModels<RegisterViewModelImpl>()

    override fun obtainLayoutId() = R.layout.register_fragment

    override suspend fun handleState(state: RegisterState) = when (state) {
        RegisterState.Initial -> offerToViewModel(RegisterIntent.ViewReady)
        RegisterState.RegisterError -> showRegisterError()
    }

    override fun attachListeners() {
        super.attachListeners()
        registerFragmentLoginBtn.setOnClickListener {
            clearRegisterError()
            offerToViewModel(buildRegisterUserIntent())
        }
    }

    private fun buildRegisterUserIntent() =
        RegisterIntent.RegisterUser(
            login = registerFragmentLoginEdit.text.toString(),
            password = registerFragmentPasswordEdit.text.toString(),
            name = registerFragmentNameEdit.text.toString()
        )

    private fun showRegisterError() {
        registerFragmentLoginEdit.error = ""
        registerFragmentNameEdit.error = ""
        registerFragmentPasswordEdit.error = ""
    }

    private fun clearRegisterError() {
        registerFragmentLoginEdit.error = null
        registerFragmentNameEdit.error = null
        registerFragmentPasswordEdit.error = null
    }
}