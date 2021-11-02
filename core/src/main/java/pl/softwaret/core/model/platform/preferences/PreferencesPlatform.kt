package pl.softwaret.core.model.platform.preferences

internal interface PreferencesPlatform {

    suspend fun removeKey(key: String)
    suspend fun keyExists(key: String): Boolean

    suspend fun <T : Any> obtainValue(key: String, default: T): T
    suspend fun <T : Any> putValue(key: String, value: T)
}