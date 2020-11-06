package pl.softwaret.kpdf.model.repository.api.entity

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(val token: String)
