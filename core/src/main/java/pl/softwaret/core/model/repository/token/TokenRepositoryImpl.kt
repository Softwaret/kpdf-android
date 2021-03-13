package pl.softwaret.core.model.repository.token

import pl.softwaret.core.model.platform.preferences.PreferencesPlatform

class TokenRepositoryImpl(
    private val preferencesPlatform: PreferencesPlatform
) : TokenRepository {

    companion object {
        private const val TOKEN_PREF_KEY = "TOKEN_PREF_KEY"
    }

    override suspend fun obtainToken() = preferencesPlatform.obtainValue(TOKEN_PREF_KEY, "")
        .ifEmpty { null }

    override suspend fun saveToken(token: String) = preferencesPlatform.putValue(TOKEN_PREF_KEY, token)
}