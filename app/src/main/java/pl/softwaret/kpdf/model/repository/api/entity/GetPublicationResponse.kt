package pl.softwaret.kpdf.model.repository.api.entity

import kotlinx.serialization.Serializable

@Serializable
data class GetPublicationResponse(
    val id: Int,
    var name: String,
    var authorLogin: String,
    val pdf: String,
    val description: String
)