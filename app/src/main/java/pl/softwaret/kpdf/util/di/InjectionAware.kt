package pl.softwaret.kpdf.util.di

import org.kodein.di.DI
import org.kodein.di.DIAware

interface InjectionAware : DIAware {

    override val di: DI
        get() = DiProvider.obtainDiInstance()
}