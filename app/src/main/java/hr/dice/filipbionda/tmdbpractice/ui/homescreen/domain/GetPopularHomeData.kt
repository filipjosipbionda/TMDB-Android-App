package hr.dice.filipbionda.tmdbpractice.ui.homescreen.domain

import hr.dice.filipbionda.tmdbpractice.data.models.ContentType
import hr.dice.filipbionda.tmdbpractice.ui.homescreen.data.repository.ApiRepository
import hr.dice.filipbionda.tmdbpractice.ui.homescreen.domain.model.HomeData
import hr.dice.filipbionda.tmdbpractice.ui.homescreen.service.api.ApiContentRoutes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetPopularHomeData (
    private val apiRepository: ApiRepository,
) {
    suspend operator fun invoke(contentType: ContentType): List<HomeData> {
        return withContext(Dispatchers.IO) {
            return@withContext apiRepository.fetchHomeData(contentType.getContentPath())
        }
    }
}

private fun ContentType.getContentPath(): String {
    return when (this) {
        ContentType.MOVIE -> ApiContentRoutes.MOVIES_POPULAR
        ContentType.SERIES -> ApiContentRoutes.SERIES_POPULAR
        ContentType.ANIME -> ApiContentRoutes.ANIME_POPULAR
        ContentType.SOAPS -> ApiContentRoutes.SOAPS_POPULAR
        ContentType.SPECIALS -> ApiContentRoutes.SPECIALS_POPULAR
    }
}
