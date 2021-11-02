package pl.softwaret.core.model.platform.time

internal interface TimePlatform {

    suspend fun obtainCurrentTimestamp(): Long
}