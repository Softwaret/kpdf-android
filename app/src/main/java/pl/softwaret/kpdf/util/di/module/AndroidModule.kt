package pl.softwaret.kpdf.util.di.module

import android.content.Context
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton
import pl.softwaret.kpdf.util.di.DiProvider

fun DiProvider.obtainAndroidModule(context: Context) = DI.Module(name = ModuleName.ANDROID.name) {
    bind<Context>() with singleton { context }
}