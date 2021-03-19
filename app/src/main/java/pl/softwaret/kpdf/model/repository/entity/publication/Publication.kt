package pl.softwaret.kpdf.model.repository.entity.publication

data class Publication(
    val id: Int,
    var name: String,
    var authorLogin: String,
    val pdf: String,
    val description: String
)