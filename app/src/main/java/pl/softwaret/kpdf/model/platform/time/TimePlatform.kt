package pl.softwaret.kpdf.model.platform.time

interface TimePlatform {

    suspend fun obtainCurrentTimestamp(): Long
}