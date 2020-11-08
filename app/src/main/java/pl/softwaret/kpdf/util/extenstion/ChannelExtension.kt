package pl.softwaret.kpdf.util.extenstion

import kotlinx.coroutines.channels.ConflatedBroadcastChannel

fun ConflatedBroadcastChannel<Unit>.offer() {
    offer(Unit)
}