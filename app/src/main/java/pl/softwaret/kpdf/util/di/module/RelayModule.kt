package pl.softwaret.kpdf.util.di.module

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton
import pl.softwaret.kpdf.viewmodel.container.main.relay.MainContainerRelay
import pl.softwaret.kpdf.viewmodel.container.main.relay.MainContainerRelayImpl

val relayModule = DI.Module(name = ModuleName.RELAY.name) {
    bind<MainContainerRelay>() with singleton { MainContainerRelayImpl() }
}