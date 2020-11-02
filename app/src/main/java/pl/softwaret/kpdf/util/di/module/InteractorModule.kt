package pl.softwaret.kpdf.util.di.module

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import pl.softwaret.kpdf.model.interactor.usecase.splash.SplashInteractor
import pl.softwaret.kpdf.model.interactor.usecase.splash.SplashInteractorImpl
import pl.softwaret.kpdf.util.di.module.name.ModuleName

val interactorModule = DI.Module(name = ModuleName.INTERACTOR.name) {
    bind<SplashInteractor>() with provider { SplashInteractorImpl(instance()) }
}