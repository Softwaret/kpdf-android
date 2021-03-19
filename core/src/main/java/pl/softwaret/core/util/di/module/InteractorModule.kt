package pl.softwaret.core.util.di.module

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import pl.softwaret.core.model.interactor.usecase.login.LoginInteractor
import pl.softwaret.core.model.interactor.usecase.login.LoginInteractorImpl
import pl.softwaret.core.model.interactor.usecase.register.RegisterInteractor
import pl.softwaret.core.model.interactor.usecase.register.RegisterInteractorImpl
import pl.softwaret.core.model.interactor.usecase.splash.SplashInteractor
import pl.softwaret.core.model.interactor.usecase.splash.SplashInteractorImpl

internal val interactorModule = DI.Module(name = CoreModuleName.INTERACTOR.name) {
    bind<SplashInteractor>() with provider { SplashInteractorImpl(instance()) }
    bind<LoginInteractor>() with provider { LoginInteractorImpl(instance()) }
    bind<RegisterInteractor>() with provider { RegisterInteractorImpl(instance()) }
}