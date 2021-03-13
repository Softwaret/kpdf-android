package pl.softwaret.kpdf.util.di.module

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import pl.softwaret.core.model.platform.preferences.PreferencesPlatform
import pl.softwaret.core.model.platform.preferences.PreferencesPlatformImpl
import pl.softwaret.core.model.platform.time.TimePlatform
import pl.softwaret.core.model.platform.time.TimePlatformImpl
import pl.softwaret.kpdf.util.di.module.name.ModuleName

val platformModule = DI.Module(name = ModuleName.PLATFORM.name) {
    bind<PreferencesPlatform>() with singleton { PreferencesPlatformImpl(instance()) }
    bind<TimePlatform>() with singleton { TimePlatformImpl() }
}