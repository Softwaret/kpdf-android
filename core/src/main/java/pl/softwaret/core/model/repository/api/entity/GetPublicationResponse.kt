package pl.softwaret.core.model.repository.api.entity

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPublicationResponse(
    val id: Int,
    var name: String,
    var authorLogin: String,
    val pdf: String,
    val description: String
)