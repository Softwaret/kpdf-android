package pl.softwaret.kpdf.util.extenstion

import pl.softwaret.kpdf.BuildConfig

fun isMockBuild() = BuildConfig.FLAVOR == "mock"