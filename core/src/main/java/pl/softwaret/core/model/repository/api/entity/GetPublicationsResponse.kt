package pl.softwaret.core.model.repository.api.entity

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPublicationsResponse(
    val publicationIds: List<Int>
)