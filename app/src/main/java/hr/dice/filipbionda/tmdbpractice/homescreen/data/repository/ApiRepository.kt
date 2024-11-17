package hr.dice.filipbionda.tmdbpractice.homescreen.data.repository

import hr.dice.filipbionda.tmdbpractice.homescreen.data.models.ApiMediaItem
import hr.dice.filipbionda.tmdbpractice.homescreen.domain.interfaces.ApiRepository
import hr.dice.filipbionda.tmdbpractice.homescreen.domain.models.HomeData
import hr.dice.filipbionda.tmdbpractice.homescreen.service.api.ApiContentRoutes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiRepositoryImpl : ApiRepository {
       override suspend fun fetchHomeData(contentPath: String): List<HomeData> {
           return withContext(Dispatchers.IO) {
                when (contentPath) {
                    ApiContentRoutes.MOVIES_POPULAR -> listOf(235L, 275L, 685L, 555L, 155L).map { id ->
                        ApiMediaItem(id = id, posterPath = "https://m.media-amazon.com/images/I/81W0QUFNudL._AC_UF894,1000_QL80_.jpg")
                    }
                    ApiContentRoutes.MOVIES ->listOf(234L, 274L, 684L, 554L, 154L).map { id ->
                        ApiMediaItem(id = id, posterPath = "https://m.media-amazon.com/images/I/5151N2hUPiL._AC_UF894,1000_QL80_.jpg")
                    }
                    ApiContentRoutes.SERIES_POPULAR -> listOf(233L, 273L, 683L, 553L, 153L).map { id ->
                        ApiMediaItem(id = id, posterPath = "https://image.tmdb.org/t/p/w500/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
                    }
                    ApiContentRoutes.SERIES -> listOf(238L, 272L, 682L, 552L, 152L).map { id ->
                        ApiMediaItem(id = id, posterPath = "https://mlpnk72yciwc.i.optimole.com/cqhiHLc.IIZS~2ef73/w:auto/h:auto/q:75/https://bleedingcool.com/wp-content/uploads/2024/10/unnamed-17-1.jpg")
                    }
                    ApiContentRoutes.ANIME_POPULAR -> listOf(231L, 271L, 681L, 551L, 151L).map { id ->
                        ApiMediaItem(id = id, posterPath = "https://i1.sndcdn.com/artworks-000510111876-8ax761-t500x500.jpg")
                    }
                    ApiContentRoutes.ANIME -> listOf(238L, 222L, 682L, 545L, 133L).map { id ->
                        ApiMediaItem(id = id, posterPath = "https://i.pinimg.com/736x/8b/03/d8/8b03d828812b27458a893109625b5a78.jpg")
                    }
                    ApiContentRoutes.SOAPS_POPULAR -> listOf(239L, 279L, 689L, 559L, 159L).map { id ->
                        ApiMediaItem(id = id, posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRzL3x4hHDAyq1ogU8Dl-wAd13T6HJqahruJaWFZdYwVueW7MK-")
                    }
                    ApiContentRoutes.SOAPS -> listOf(238L, 278L, 688L, 558L, 158L).map { id ->
                        ApiMediaItem(id = id, posterPath = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR7HTzLmKUtvWDRCj_IJWxJw8CayAM8lZ0W3Ago_B33RWT0KfwB")
                    }
                    ApiContentRoutes.SPECIALS_POPULAR -> listOf(237L, 277L, 678L, 557L, 157L).map { id ->
                        ApiMediaItem(id = id, posterPath = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR7HTzLmKUtvWDRCj_IJWxJw8CayAM8lZ0W3Ago_B33RWT0KfwB")
                    }
                    ApiContentRoutes.SPECIALS ->  listOf(265L, 276L, 646L, 656L, 156L).map { id ->
                        ApiMediaItem(id = id, posterPath = "https://m.media-amazon.com/images/I/5151N2hUPiL._AC_UF894,1000_QL80_.jpg")
                    }
                   else -> emptyList()
               }.toHomeDataList()
           }
        }
    }

private fun List<ApiMediaItem>.toHomeDataList(): List<HomeData> = map { apiMediaItem ->
    HomeData(
        id = apiMediaItem.id,
        imagePath = apiMediaItem.posterPath
    )
}

