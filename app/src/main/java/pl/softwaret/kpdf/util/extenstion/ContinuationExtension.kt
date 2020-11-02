package pl.softwaret.kpdf.util.extenstion

import kotlinx.coroutines.CancellableContinuation
import kotlin.coroutines.resume

fun <ValueType> CancellableContinuation<ValueType>.resumeIfActive(value: ValueType) {
    if (isActive) {
        resume(value)
    }
}