package pl.softwaret.kpdf.viewmodel.container.main.relay

import pl.softwaret.kpdf.util.`typealias`.SignalFlow

class MainContainerRelayImpl : MainContainerRelay {

    override val moveToLoginEvent = SignalFlow()
}