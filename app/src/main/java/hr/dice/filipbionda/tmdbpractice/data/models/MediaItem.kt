package hr.dice.filipbionda.tmdbpractice.data.models

data class MediaItem (
    val title: String,
    val coverPath: String,
    val rating: Int,
    val duration: Long?,
    val date: String,
    val language: String,
    val overview: String,
    val actors: List<Actor>,
    val categories: List<String>,
    val seasons: Int?,
    val trailerUrl: String
)
