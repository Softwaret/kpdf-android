package pl.softwaret.kpdf.view.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pl.softwaret.kpdf.R
import pl.softwaret.kpdf.viewmodel.base.BaseIntent
import pl.softwaret.kpdf.viewmodel.base.BaseState
import pl.softwaret.kpdf.viewmodel.base.ViewModel

abstract class BaseContainerActivity<IntentType : BaseIntent,
        StateType : BaseState, ViewModelType : ViewModel<IntentType, StateType>> : AppCompatActivity() {

    protected abstract val viewModel: ViewModelType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(obtainLayoutId())
        checkNotNull(findViewById(R.id.fragmentContainer)) { "FragmentContainer not provided in container activity" }

        bindToViewModel()
    }

    @LayoutRes
    protected abstract fun obtainLayoutId(): Int

    private fun bindToViewModel() = viewModel.state.onEach { handleState(it) }.launchIn(lifecycleScope)

    abstract suspend fun handleState(state: StateType)

    protected fun offerToViewModel(intent: IntentType) {
        viewModel.intent.offer(intent)
    }

    protected fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    protected fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}