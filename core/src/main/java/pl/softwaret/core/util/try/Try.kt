package pl.softwaret.core.util.`try`

sealed class Try<out ValueType, out ErrorType> {

    companion object;

    data class Value<out ValueType>(val value: ValueType) : Try<ValueType, Nothing>()

    data class Error<out ErrorType>(val error: ErrorType) : Try<Nothing, ErrorType>()
}
