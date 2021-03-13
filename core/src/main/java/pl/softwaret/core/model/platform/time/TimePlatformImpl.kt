package pl.softwaret.core.model.platform.time

class TimePlatformImpl : TimePlatform {

    override suspend fun obtainCurrentTimestamp() = System.currentTimeMillis() / 1000
}