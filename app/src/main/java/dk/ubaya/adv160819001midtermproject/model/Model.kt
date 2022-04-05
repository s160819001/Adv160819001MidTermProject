package dk.ubaya.adv160819001midtermproject.model


data class Book(
    val isbn:String?,
    val title:String?,
    val author:String?,
    val publisher:String?,
    val year:String?,
    val synopsis:String?,
    val location:String?
)

data class Thesis(
    val id:String?,
    val title:String?,
    val author: String?,
    val year: String?,
)