package hr.dice.filipbionda.tmdbpractice.ui.homescreen.di

import hr.dice.filipbionda.tmdbpractice.ui.homescreen.data.repository.ApiRepository
import hr.dice.filipbionda.tmdbpractice.ui.homescreen.domain.GetHomeData
import hr.dice.filipbionda.tmdbpractice.ui.homescreen.domain.GetPopularHomeData

object HomeObjectGraph {
    fun getHomeData(): GetHomeData {
        return GetHomeData(
            apiRepository = getApiRepository()
        )
    }

    private fun getApiRepository(): ApiRepository {
        return ApiRepository()
    }

    fun getPopularHomeData(): GetPopularHomeData {
        return GetPopularHomeData(
            apiRepository = getApiRepository()
        )
    }
}
