package pl.softwaret.kpdf.viewmodel.base

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.StateFlow

interface ViewModel<IntentType : BaseIntent, StateType : BaseState> {
    val state: StateFlow<StateType>
    val intent: Channel<IntentType>
}