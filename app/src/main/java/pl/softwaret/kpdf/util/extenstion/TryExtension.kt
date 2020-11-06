package pl.softwaret.kpdf.util.extenstion

import pl.softwaret.kpdf.util.`try`.Try


val Try.Companion.Value get() = Try.Value(Unit)

val Try.Companion.Error get() = Try.Error(Unit)

fun <ValueType> ValueType.asValue() = Try.Value(this)

fun <ErrorType> ErrorType.asError() = Try.Error(this)

val <ValueType, ErrorType> Try<ValueType, ErrorType>.isValue
    get() = this is Try.Value

val <ValueType, ErrorType> Try<ValueType, ErrorType>.isError
    get() = this is Try.Error

inline fun <ValueType, ErrorType> Try<ValueType, ErrorType>.onValue(
    block: (value: ValueType) -> Unit
): Try<ValueType, ErrorType> {
    if (this is Try.Value) {
        block(value)
    }
    return this
}

inline fun <ValueType, ErrorType> Try<ValueType, ErrorType>.onError(
    block: (error: ErrorType) -> Unit
): Try<ValueType, ErrorType> {
    if (this is Try.Error) {
        block(error)
    }
    return this
}

inline fun <ValueType, ErrorType> Try<ValueType, ErrorType>.onError(
    error: ErrorType, block: () -> Unit
) = onError {
    if (it == error) {
        block()
    }
}

inline fun <ValueType, ErrorType, ResultType> Try<ValueType, ErrorType>.mapValue(
    block: (value: ValueType) -> ResultType
) = when (this) {
    is Try.Value -> Try.Value(block(value))
    is Try.Error -> this
}

inline fun <ValueType, ErrorType, ResultType> Try<ValueType, ErrorType>.mapError(
    block: (value: ErrorType) -> ResultType
) = when (this) {
    is Try.Value -> this
    is Try.Error -> Try.Error(block(error))
}

inline fun <ValueType, ErrorType, ResultType> Try<ValueType, ErrorType>.flatMapValue(
    block: (value: ValueType) -> Try<ResultType, ErrorType>
) = when (this) {
    is Try.Value -> block(value)
    is Try.Error -> this
}

inline fun <ValueType, ErrorType, JoinType> Try<ValueType, ErrorType>.flatJoinValue(
    block: (value: ValueType) -> Try<JoinType, ErrorType>
) = when (this) {
    is Try.Value -> block(value).mapValue { value to it }
    is Try.Error -> error.asError()
}

inline fun <ValueType, ErrorType, ResultType, ResultErrorType> Try<ValueType, ErrorType>.flatMapValue(
    errorMapper: (ResultErrorType) -> ErrorType,
    block: (value: ValueType) -> Try<ResultType, ResultErrorType>
) = flatMapValue { block(it).mapError(errorMapper) }

inline fun <ValueType, ErrorType> Try<ValueType, ErrorType>.joinToError(
    block: (ValueType) -> ErrorType
) = when (this) {
    is Try.Value -> block(value)
    is Try.Error -> error
}

inline fun <ValueType, ErrorType> Try<ValueType, ErrorType>.joinToValue(
    block: (error: ErrorType) -> ValueType
) = when (this) {
    is Try.Value -> value
    is Try.Error -> block(error)
}

val <ValueType, ErrorType> Try<ValueType, ErrorType>.valueOrNull
    get() = joinToValue { null }

val <ValueType, ErrorType> Try<ValueType, ErrorType>.errorOrNull
    get() = joinToError { null }

inline fun <ValueType> runTrying(block: () -> ValueType) =
    try {
        block().asValue()
    } catch (e: Throwable) {
        e.asError()
    }