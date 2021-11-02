package pl.softwaret.core.util.di.module

import org.kodein.di.DI

object CoreDIModules {
    val modules: Set<DI.Module> = setOf(interactorModule, repositoryModule, serviceModule, platformModule,)
}