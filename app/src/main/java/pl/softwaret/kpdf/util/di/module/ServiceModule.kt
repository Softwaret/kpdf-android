package pl.softwaret.kpdf.util.di.module

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import pl.softwaret.kpdf.model.repository.api.ApiService
import pl.softwaret.kpdf.model.repository.api.ApiServiceImpl
import pl.softwaret.kpdf.model.repository.api.MockApiServiceImpl
import pl.softwaret.kpdf.model.service.token.TokenService
import pl.softwaret.kpdf.model.service.token.TokenServiceImpl
import pl.softwaret.kpdf.util.di.module.name.ModuleName
import pl.softwaret.kpdf.util.extenstion.isMockBuild

val serviceModule = DI.Module(name = ModuleName.SERVICE.name) {
    bind<TokenService>() with singleton { TokenServiceImpl(instance()) }
    bind<ApiService>() with singleton { buildApiService() }
}

private fun buildApiService() = if (isMockBuild()) {
    MockApiServiceImpl()
} else {
    ApiServiceImpl()
}