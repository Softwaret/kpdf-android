package pl.softwaret.core.util.di.module

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import pl.softwaret.core.model.repository.login.LoginRepository
import pl.softwaret.core.model.repository.login.LoginRepositoryImpl
import pl.softwaret.core.model.repository.token.TokenRepository
import pl.softwaret.core.model.repository.token.TokenRepositoryImpl

internal val repositoryModule = DI.Module(name = CoreModuleName.REPOSITORY.name) {
    bind<TokenRepository>() with singleton { TokenRepositoryImpl(instance()) }
    bind<LoginRepository>() with singleton { LoginRepositoryImpl(instance()) }
}