package pl.softwaret.core.model.repository.token

import pl.softwaret.core.model.platform.preferences.PreferencesPlatform

internal class TokenRepositoryImpl(
    private val preferencesPlatform: PreferencesPlatform
) : TokenRepository {

    companion object {
        private const val TOKEN_PREF_KEY = "TOKEN_PREF_KEY"
        private const val REFRESH_TOKEN_PREF_KEY = "REFRESH_TOKEN_PREF_KEY"
    }

    override suspend fun obtainToken() = preferencesPlatform
        .obtainValue(TOKEN_PREF_KEY, "")
        .ifEmpty { null }

    override suspend fun saveToken(token: String) =
        preferencesPlatform.putValue(TOKEN_PREF_KEY, token)

    override suspend fun obtainRefreshToken() = preferencesPlatform
        .obtainValue(REFRESH_TOKEN_PREF_KEY, "")
        .ifEmpty { null }

    override suspend fun saveRefreshToken(refreshToken: String) =
        preferencesPlatform.putValue(REFRESH_TOKEN_PREF_KEY, refreshToken)
}