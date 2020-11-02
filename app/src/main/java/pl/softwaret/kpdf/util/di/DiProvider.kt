package pl.softwaret.kpdf.util.di

import android.content.Context
import org.kodein.di.DI
import pl.softwaret.kpdf.util.di.module.*
import kotlin.properties.Delegates

object DiProvider {

    private var diInstance: DI by Delegates.notNull()

    fun setupDiProvider(applicationContext: Context) {
        diInstance = DI {
            importAll(interactorModule, repositoryModule, serviceModule, platformModule, relayModule)

            import(obtainAndroidModule(applicationContext))
        }
    }

    fun obtainDiInstance() = diInstance
}