@file:Suppress("FunctionName")

package pl.softwaret.kpdf.util.`typealias`

import kotlinx.coroutines.flow.MutableStateFlow

typealias SignalFlow = MutableStateFlow<Boolean>

fun SignalFlow() = MutableStateFlow(false)

fun SignalFlow.sendSignal() {
    this.value = value.not()
}