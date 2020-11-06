package pl.softwaret.kpdf.viewmodel.container.main.relay

import pl.softwaret.kpdf.util.`typealias`.SignalFlow

interface MainContainerRelay {

    val moveToLoginEvent: SignalFlow
    val moveToRegisterEvent: SignalFlow
    val moveToHomeEvent: SignalFlow
}