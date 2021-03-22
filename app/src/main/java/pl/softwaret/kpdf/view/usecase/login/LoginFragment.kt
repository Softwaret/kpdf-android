package pl.softwaret.kpdf.view.usecase.login

import android.widget.Toast
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.login_fragment.*
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

    override fun onViewReady() {
        super.onViewReady()
        loginFragmentLoginBtn.setOnClickListener {
            offerToViewModel(buildOnLoginIntent())
        }
        loginFragmentRegisterLabel.setOnClickListener { offerToViewModel(LoginIntent.OnRegister)}
    }

    private fun buildOnLoginIntent() =
        LoginIntent.OnLogin(loginFragmentLoginEdit.text.toString(), loginFragmentPasswordEdit.text.toString())

    override suspend fun handleState(state: LoginState) = when (state) {
        LoginState.Initial -> offerToViewModel(LoginIntent.ViewReady)
        LoginState.CredentialsError -> showCredentialsError()
    }

    private fun showCredentialsError() {
        Toast.makeText(context, "Wrong credentials", Toast.LENGTH_SHORT).show()
    }
}