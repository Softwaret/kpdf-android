package pl.softwaret.kpdf.util.di

import android.content.Context
import org.kodein.di.DI
import pl.softwaret.core.util.di.module.*
import pl.softwaret.kpdf.util.di.module.obtainAndroidModule
import pl.softwaret.kpdf.util.di.module.relayModule
import kotlin.properties.Delegates

object DiProvider {

    private var diInstance: DI by Delegates.notNull()

    fun setupDiProvider(applicationContext: Context) {
        diInstance = DI {
            importAll(CoreDIModules.modules + relayModule)

            import(obtainAndroidModule(applicationContext))
        }
    }

    fun obtainDiInstance() = diInstance
}