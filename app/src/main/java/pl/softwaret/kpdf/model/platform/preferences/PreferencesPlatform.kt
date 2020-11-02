package pl.softwaret.kpdf.model.platform.preferences

interface PreferencesPlatform {

    suspend fun removeKey(key: String)
    suspend fun keyExists(key: String): Boolean

    suspend fun <T : Any> obtainValue(key: String, default: T): T
    suspend fun <T : Any> putValue(key: String, value: T)
}