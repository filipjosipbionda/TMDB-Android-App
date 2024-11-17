package hr.dice.filipbionda.tmdbpractice.homescreen.di

import hr.dice.filipbionda.tmdbpractice.homescreen.data.repository.ApiRepositoryImpl
import hr.dice.filipbionda.tmdbpractice.homescreen.domain.GetHomeData
import hr.dice.filipbionda.tmdbpractice.homescreen.domain.GetPopularHomeData
import hr.dice.filipbionda.tmdbpractice.homescreen.domain.interfaces.ApiRepository

object HomeObjectGraph {
    fun getHomeData(): GetHomeData {
        return GetHomeData(
            apiRepository = getApiRepository()
        )
    }

    private fun getApiRepository(): ApiRepository {
        return ApiRepositoryImpl()
    }

    fun getPopularHomeData(): GetPopularHomeData {
        return GetPopularHomeData(
            apiRepository = getApiRepository()
        )
    }
}
