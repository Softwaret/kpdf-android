package pl.softwaret.kpdf.util.di.module

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import pl.softwaret.core.model.repository.login.LoginRepository
import pl.softwaret.core.model.repository.login.LoginRepositoryImpl
import pl.softwaret.core.model.repository.token.TokenRepository
import pl.softwaret.core.model.repository.token.TokenRepositoryImpl
import pl.softwaret.kpdf.util.di.module.name.ModuleName

val repositoryModule = DI.Module(name = ModuleName.REPOSITORY.name) {
    bind<TokenRepository>() with singleton { TokenRepositoryImpl(instance()) }
    bind<LoginRepository>() with singleton { LoginRepositoryImpl(instance()) }
}