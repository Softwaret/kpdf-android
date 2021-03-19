package pl.softwaret.core.model.platform.time

internal class TimePlatformImpl : TimePlatform {

    override suspend fun obtainCurrentTimestamp() = System.currentTimeMillis() / 1000
}