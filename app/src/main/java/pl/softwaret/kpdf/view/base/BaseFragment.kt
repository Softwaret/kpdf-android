package pl.softwaret.kpdf.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pl.softwaret.kpdf.viewmodel.base.BaseIntent
import pl.softwaret.kpdf.viewmodel.base.BaseState
import pl.softwaret.kpdf.viewmodel.base.ViewModel

abstract class BaseFragment<IntentType : BaseIntent,
        StateType : BaseState, ViewModelType : ViewModel<IntentType, StateType>> : Fragment() {

    protected abstract val viewModel: ViewModelType

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(obtainLayoutId(), container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachListeners()
        bindToViewModel()
    }

    @LayoutRes
    protected abstract fun obtainLayoutId(): Int

    protected open fun attachListeners() {}

    private fun bindToViewModel() = viewModel.state.onEach { handleState(it) }.launchIn(lifecycleScope)

    abstract suspend fun handleState(state: StateType)

    protected fun offerToViewModel(intent: IntentType) {
        viewModel.intent.offer(intent)
    }
}