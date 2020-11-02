package pl.softwaret.kpdf.view

import android.app.Application
import pl.softwaret.kpdf.BuildConfig
import pl.softwaret.kpdf.util.di.DiProvider
import timber.log.Timber

@Suppress("unused") // Used in manifest
class KpdfApp : Application() {

    override fun onCreate() {
        super.onCreate()
        plantTimber()
        initDi()
    }

    private fun plantTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initDi() {
        DiProvider.setupDiProvider(applicationContext)
    }
}