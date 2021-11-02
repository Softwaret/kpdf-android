package pl.softwaret.core.model.platform.preferences

import android.content.Context
import com.cioccarellia.ksprefs.KsPrefs
import com.cioccarellia.ksprefs.config.EncryptionType
import com.cioccarellia.ksprefs.config.model.CommitStrategy

internal class PreferencesPlatformImpl(
    context: Context
) : PreferencesPlatform {

    private val prefs = KsPrefs(context) {
        encryptionType = EncryptionType.Base64()
        commitStrategy = CommitStrategy.APPLY
        mode = Context.MODE_PRIVATE
    }

    override suspend fun keyExists(key: String) = prefs.exists(key)

    override suspend fun removeKey(key: String) = prefs.remove(key)

    override suspend fun <T : Any> obtainValue(key: String, default: T) = prefs.pull(key, default)

    override suspend fun <T : Any> putValue(key: String, value: T) = prefs.push(key, value)
}
