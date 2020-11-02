package pl.softwaret.kpdf.view.usecase.login

import androidx.fragment.app.viewModels
import pl.softwaret.kpdf.R
import pl.softwaret.kpdf.view.base.BaseFragment
import pl.softwaret.kpdf.viewmodel.usecase.login.LoginIntent
import pl.softwaret.kpdf.viewmodel.usecase.login.LoginState
import pl.softwaret.kpdf.viewmodel.usecase.login.LoginViewModel
import pl.softwaret.kpdf.viewmodel.usecase.login.LoginViewModelImpl


class LoginFragment : BaseFragment<LoginIntent, LoginState, LoginViewModel>() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    override val viewModel: LoginViewModel by viewModels<LoginViewModelImpl>()

    override fun obtainLayoutId() = R.layout.login_fragment

    override suspend fun handleState(state: LoginState) = when (state) {
        LoginState.Initial -> offerToViewModel(LoginIntent.ViewReady)
    }
}