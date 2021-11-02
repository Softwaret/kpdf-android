package pl.softwaret.core.model.repository.api.entity

import kotlinx.serialization.Serializable

@Serializable
internal data class RefreshTokenResponse(
    val token: String,
    val refreshToken: String
)