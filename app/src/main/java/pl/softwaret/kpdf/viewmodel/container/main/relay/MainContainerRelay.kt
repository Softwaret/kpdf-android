package pl.softwaret.kpdf.viewmodel.container.main.relay

import kotlinx.coroutines.channels.ConflatedBroadcastChannel

@Suppress("EXPERIMENTAL_API_USAGE")
interface MainContainerRelay {

    val moveToLoginEvent: ConflatedBroadcastChannel<Unit>
    val moveToRegisterEvent: ConflatedBroadcastChannel<Unit>
    val moveToHomeEvent: ConflatedBroadcastChannel<Unit>
}