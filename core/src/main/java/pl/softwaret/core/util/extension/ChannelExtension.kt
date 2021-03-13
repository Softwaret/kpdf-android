package pl.softwaret.core.util.extension

import kotlinx.coroutines.channels.ConflatedBroadcastChannel

fun ConflatedBroadcastChannel<Unit>.offer() {
    offer(Unit)
}