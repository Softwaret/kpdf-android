package pl.softwaret.core.util.di.module

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import pl.softwaret.core.model.repository.api.ApiService
import pl.softwaret.core.model.repository.api.ApiServiceImpl
import pl.softwaret.core.model.repository.api.MockApiServiceImpl
import pl.softwaret.core.model.service.publication.PublicationService
import pl.softwaret.core.model.service.publication.PublicationServiceImpl
import pl.softwaret.core.model.service.token.TokenService
import pl.softwaret.core.model.service.token.TokenServiceImpl
import pl.softwaret.core.util.extension.isMockBuild

internal val serviceModule = DI.Module(name = CoreModuleName.SERVICE.name) {
    bind<TokenService>() with singleton { TokenServiceImpl(instance()) }
    bind<PublicationService>() with singleton { PublicationServiceImpl(instance()) }

    bind<ApiService>() with singleton { buildApiService() }
}

private fun buildApiService() = if (isMockBuild()) {
    MockApiServiceImpl()
} else {
    ApiServiceImpl()
}