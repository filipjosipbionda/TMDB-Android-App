package hr.dice.filipbionda.tmdbpractice.ui.homescreen.service.api

object ApiContentRoutes {
    const val MOVIES = "/movie/popular?api_key=${Api.KEY}&page=2"
    const val MOVIES_POPULAR = "/movie/popular?api_key=${Api.KEY}&page=1"
    const val SERIES = "/discover/tv/popular?api_key=${Api.KEY}&page=2"
    const val SERIES_POPULAR = "/discover/tv/popular?api_key=${Api.KEY}&page=1"
    const val ANIME = "/discover/tv?api_key=${Api.KEY}&with_genres=${ApiGenresId.ANIME}&sort_by=popularity.desc&with_original_language=en&page=2"
    const val ANIME_POPULAR = "/discover/tv?api_key=${Api.KEY}&with_genres=${ApiGenresId.ANIME}&sort_by=popularity.desc&with_original_language=en&page=1"
    const val SOAPS = "/discover/tv?api_key=${Api.KEY}&with_genres=${ApiGenresId.SOAPS}&sort_by=popularity.desc&with_original_language=en&page=2"
    const val SOAPS_POPULAR = "/discover/tv?api_key=${Api.KEY}&with_genres=${ApiGenresId.SOAPS}&sort_by=popularity.desc&with_original_language=en&page=1"
    const val SPECIALS = "/movie/popular?api_key=${Api.KEY}&page=4"
    const val SPECIALS_POPULAR = "/movie/popular?api_key=${Api.KEY}&page=3"
}
