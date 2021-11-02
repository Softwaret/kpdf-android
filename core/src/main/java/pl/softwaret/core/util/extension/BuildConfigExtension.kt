package pl.softwaret.core.util.extension

import pl.softwaret.core.BuildConfig

fun isMockBuild() = BuildConfig.FLAVOR == "mock"