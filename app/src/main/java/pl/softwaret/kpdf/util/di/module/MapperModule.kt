package pl.softwaret.kpdf.util.di.module

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton
import pl.softwaret.core.model.repository.entity.publication.PublicationMapper
import pl.softwaret.core.model.repository.entity.publication.PublicationMapperImpl
import pl.softwaret.kpdf.util.di.module.name.ModuleName

val mapperModule = DI.Module(name = ModuleName.MAPPER.name) {

    bind<PublicationMapper>() with singleton { PublicationMapperImpl() }
}
