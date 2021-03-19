package pl.softwaret.core.model.repository.entity.publication

internal data class Publication(
    val id: Int,
    var name: String,
    var authorLogin: String,
    val pdf: String,
    val description: String
)