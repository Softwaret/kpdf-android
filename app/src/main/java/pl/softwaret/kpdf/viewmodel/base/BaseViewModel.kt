package pl.softwaret.kpdf.viewmodel.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.plus
import pl.softwaret.kpdf.util.di.InjectionAware
import timber.log.Timber

abstract class BaseViewModel<IntentType : BaseIntent, StatusType : BaseState> : ViewModel(),
    InjectionAware {

    abstract val state: StateFlow<StatusType>
    val intent = Channel<IntentType>()

    private val exceptionHandler = CoroutineExceptionHandler { _, exception -> handleException(exception) }
    protected val coroutineScope = (viewModelScope + exceptionHandler)

    init {
        bindToScope()
    }

    private fun bindToScope() {
        intent.consumeAsFlow().onEach { handleIntent(it) }.launchIn(coroutineScope)
    }


    protected abstract suspend fun handleIntent(intent: IntentType)

    protected open fun handleException(exception: Throwable) {
        Timber.e(exception)
    }
}