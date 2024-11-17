package hr.dice.filipbionda.tmdbpractice.homescreen.domain.interfaces

import hr.dice.filipbionda.tmdbpractice.homescreen.domain.models.HomeData

interface ApiRepository {
    suspend fun fetchHomeData(contentPath: String): List<HomeData>
}
