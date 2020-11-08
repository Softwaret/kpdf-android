package pl.softwaret.kpdf.viewmodel.container.main.relay

import kotlinx.coroutines.channels.ConflatedBroadcastChannel

@Suppress("EXPERIMENTAL_API_USAGE")
class MainContainerRelayImpl : MainContainerRelay {

    override val moveToLoginEvent = ConflatedBroadcastChannel<Unit>()
    override val moveToRegisterEvent = ConflatedBroadcastChannel<Unit>()
    override val moveToHomeEvent = ConflatedBroadcastChannel<Unit>()
}