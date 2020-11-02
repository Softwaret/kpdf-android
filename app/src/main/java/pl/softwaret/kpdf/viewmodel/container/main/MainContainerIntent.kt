package pl.softwaret.kpdf.viewmodel.container.main

import pl.softwaret.kpdf.viewmodel.base.BaseIntent

sealed class MainContainerIntent : BaseIntent() {
    object ViewReady : MainContainerIntent()
}
