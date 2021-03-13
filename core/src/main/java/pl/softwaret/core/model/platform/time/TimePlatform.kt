package pl.softwaret.core.model.platform.time

interface TimePlatform {

    suspend fun obtainCurrentTimestamp(): Long
}