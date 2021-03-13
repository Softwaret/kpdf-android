package pl.softwaret.core.util.di.module

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton
import pl.softwaret.core.model.repository.entity.publication.PublicationMapper
import pl.softwaret.core.model.repository.entity.publication.PublicationMapperImpl

val mapperModule = DI.Module(name = CoreModuleName.MAPPER.name) {

    bind<PublicationMapper>() with singleton { PublicationMapperImpl() }
}
