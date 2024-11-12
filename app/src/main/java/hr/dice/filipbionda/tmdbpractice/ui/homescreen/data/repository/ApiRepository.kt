package hr.dice.filipbionda.tmdbpractice.ui.homescreen.data.repository

import hr.dice.filipbionda.tmdbpractice.ui.homescreen.data.model.ApiMediaItem
import hr.dice.filipbionda.tmdbpractice.ui.homescreen.domain.model.HomeData
import hr.dice.filipbionda.tmdbpractice.ui.homescreen.service.api.ApiContentRoutes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiRepository {
       suspend fun fetchHomeData(contentPath: String): List<HomeData> {
           return withContext(Dispatchers.IO) {
                when (contentPath) {
                   ApiContentRoutes.MOVIES_POPULAR -> listOf(
                       ApiMediaItem(id = 238, posterPath = "https://m.media-amazon.com/images/I/81W0QUFNudL._AC_UF894,1000_QL80_.jpg"),
                       ApiMediaItem(id = 278, posterPath = "https://m.media-amazon.com/images/I/81W0QUFNudL._AC_UF894,1000_QL80_.jpg"),
                       ApiMediaItem(id = 680, posterPath = "https://m.media-amazon.com/images/I/81W0QUFNudL._AC_UF894,1000_QL80_.jpg"),
                       ApiMediaItem(id = 550, posterPath = "https://m.media-amazon.com/images/I/81W0QUFNudL._AC_UF894,1000_QL80_.jpg"),
                       ApiMediaItem(id = 155, posterPath = "https://m.media-amazon.com/images/I/81W0QUFNudL._AC_UF894,1000_QL80_.jpg")
                   )
                   ApiContentRoutes.MOVIES -> listOf(
                       ApiMediaItem(id = 424, posterPath = "https://m.media-amazon.com/images/I/5151N2hUPiL._AC_UF894,1000_QL80_.jpg"),
                       ApiMediaItem(id = 769, posterPath = "https://m.media-amazon.com/images/I/5151N2hUPiL._AC_UF894,1000_QL80_.jpg"),
                       ApiMediaItem(id = 399, posterPath = "https://m.media-amazon.com/images/I/5151N2hUPiL._AC_UF894,1000_QL80_.jpg"),
                       ApiMediaItem(id = 634, posterPath = "https://m.media-amazon.com/images/I/5151N2hUPiL._AC_UF894,1000_QL80_.jpg"),
                       ApiMediaItem(id = 580, posterPath = "https://m.media-amazon.com/images/I/5151N2hUPiL._AC_UF894,1000_QL80_.jpg")
                   )
                   ApiContentRoutes.SERIES_POPULAR -> listOf(
                       ApiMediaItem(id = 1399, posterPath = "https://image.tmdb.org/t/p/w500/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"),
                       ApiMediaItem(id = 60735, posterPath = "https://image.tmdb.org/t/p/w500/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"),
                       ApiMediaItem(id = 1668, posterPath = "https://image.tmdb.org/t/p/w500/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"),
                       ApiMediaItem(id = 1412, posterPath = "https://image.tmdb.org/t/p/w500/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"),
                       ApiMediaItem(id = 82856, posterPath = "https://image.tmdb.org/t/p/w500/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
                   )
                   ApiContentRoutes.SERIES -> listOf(
                       ApiMediaItem(id = 1416, posterPath = "https://mlpnk72yciwc.i.optimole.com/cqhiHLc.IIZS~2ef73/w:auto/h:auto/q:75/https://bleedingcool.com/wp-content/uploads/2024/10/unnamed-17-1.jpg"),
                       ApiMediaItem(id = 42009, posterPath = "https://mlpnk72yciwc.i.optimole.com/cqhiHLc.IIZS~2ef73/w:auto/h:auto/q:75/https://bleedingcool.com/wp-content/uploads/2024/10/unnamed-17-1.jpg"),
                       ApiMediaItem(id = 40214, posterPath = "https://mlpnk72yciwc.i.optimole.com/cqhiHLc.IIZS~2ef73/w:auto/h:auto/q:75/https://bleedingcool.com/wp-content/uploads/2024/10/unnamed-17-1.jpg"),
                       ApiMediaItem(id = 44217, posterPath = "https://mlpnk72yciwc.i.optimole.com/cqhiHLc.IIZS~2ef73/w:auto/h:auto/q:75/https://bleedingcool.com/wp-content/uploads/2024/10/unnamed-17-1.jpg"),
                       ApiMediaItem(id = 39754, posterPath = "https://mlpnk72yciwc.i.optimole.com/cqhiHLc.IIZS~2ef73/w:auto/h:auto/q:75/https://bleedingcool.com/wp-content/uploads/2024/10/unnamed-17-1.jpg")
                   )
                   ApiContentRoutes.ANIME_POPULAR -> listOf(
                       ApiMediaItem(id = 92511, posterPath = "https://i1.sndcdn.com/artworks-000510111876-8ax761-t500x500.jpg"),
                       ApiMediaItem(id = 37854, posterPath = "https://i1.sndcdn.com/artworks-000510111876-8ax761-t500x500.jpg"),
                       ApiMediaItem(id = 73182, posterPath = "https://i1.sndcdn.com/artworks-000510111876-8ax761-t500x500.jpg"),
                       ApiMediaItem(id = 123, posterPath = "https://i1.sndcdn.com/artworks-000510111876-8ax761-t500x500.jpg"),
                       ApiMediaItem(id = 67045, posterPath = "https://i1.sndcdn.com/artworks-000510111876-8ax761-t500x500.jpg")
                   )
                   ApiContentRoutes.ANIME -> listOf(
                       ApiMediaItem(id = 18426, posterPath = "https://i.pinimg.com/736x/8b/03/d8/8b03d828812b27458a893109625b5a78.jpg"),
                       ApiMediaItem(id = 11295, posterPath = "https://i.pinimg.com/736x/8b/03/d8/8b03d828812b27458a893109625b5a78.jpg"),
                       ApiMediaItem(id = 67498, posterPath = "https://i.pinimg.com/736x/8b/03/d8/8b03d828812b27458a893109625b5a78.jpg"),
                       ApiMediaItem(id = 12532, posterPath = "https://i.pinimg.com/736x/8b/03/d8/8b03d828812b27458a893109625b5a78.jpg"),
                       ApiMediaItem(id = 56579, posterPath = "https://i.pinimg.com/736x/8b/03/d8/8b03d828812b27458a893109625b5a78.jpg")
                   )
                   ApiContentRoutes.SOAPS_POPULAR -> listOf(
                       ApiMediaItem(id = 11186, posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRzL3x4hHDAyq1ogU8Dl-wAd13T6HJqahruJaWFZdYwVueW7MK-"),
                       ApiMediaItem(id = 66014, posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRzL3x4hHDAyq1ogU8Dl-wAd13T6HJqahruJaWFZdYwVueW7MK-"),
                       ApiMediaItem(id = 1985, posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRzL3x4hHDAyq1ogU8Dl-wAd13T6HJqahruJaWFZdYwVueW7MK-"),
                       ApiMediaItem(id = 1991, posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRzL3x4hHDAyq1ogU8Dl-wAd13T6HJqahruJaWFZdYwVueW7MK-"),
                       ApiMediaItem(id = 1996, posterPath = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRzL3x4hHDAyq1ogU8Dl-wAd13T6HJqahruJaWFZdYwVueW7MK-")
                   )
                   ApiContentRoutes.SOAPS -> listOf(
                       ApiMediaItem(id = 21334, posterPath = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR7HTzLmKUtvWDRCj_IJWxJw8CayAM8lZ0W3Ago_B33RWT0KfwB"),
                       ApiMediaItem(id = 49230, posterPath = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR7HTzLmKUtvWDRCj_IJWxJw8CayAM8lZ0W3Ago_B33RWT0KfwB"),
                       ApiMediaItem(id = 48213, posterPath = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR7HTzLmKUtvWDRCj_IJWxJw8CayAM8lZ0W3Ago_B33RWT0KfwB"),
                       ApiMediaItem(id = 56498, posterPath = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR7HTzLmKUtvWDRCj_IJWxJw8CayAM8lZ0W3Ago_B33RWT0KfwB"),
                       ApiMediaItem(id = 63145, posterPath = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR7HTzLmKUtvWDRCj_IJWxJw8CayAM8lZ0W3Ago_B33RWT0KfwB")
                   )
                   ApiContentRoutes.SPECIALS_POPULAR -> listOf(
                       ApiMediaItem(id = 238, posterPath = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR7HTzLmKUtvWDRCj_IJWxJw8CayAM8lZ0W3Ago_B33RWT0KfwB"),
                       ApiMediaItem(id = 278, posterPath = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR7HTzLmKUtvWDRCj_IJWxJw8CayAM8lZ0W3Ago_B33RWT0KfwB"),
                       ApiMediaItem(id = 680, posterPath = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR7HTzLmKUtvWDRCj_IJWxJw8CayAM8lZ0W3Ago_B33RWT0KfwB"),
                       ApiMediaItem(id = 550, posterPath = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR7HTzLmKUtvWDRCj_IJWxJw8CayAM8lZ0W3Ago_B33RWT0KfwB"),
                       ApiMediaItem(id = 155, posterPath = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR7HTzLmKUtvWDRCj_IJWxJw8CayAM8lZ0W3Ago_B33RWT0KfwB")
                   )
                   ApiContentRoutes.SPECIALS -> listOf(
                       ApiMediaItem(id = 424, posterPath = "https://m.media-amazon.com/images/I/5151N2hUPiL._AC_UF894,1000_QL80_.jpg"),
                       ApiMediaItem(id = 769, posterPath = "https://m.media-amazon.com/images/I/5151N2hUPiL._AC_UF894,1000_QL80_.jpg"),
                       ApiMediaItem(id = 399, posterPath = "https://m.media-amazon.com/images/I/5151N2hUPiL._AC_UF894,1000_QL80_.jpg"),
                       ApiMediaItem(id = 634, posterPath = "https://m.media-amazon.com/images/I/5151N2hUPiL._AC_UF894,1000_QL80_.jpg"),
                       ApiMediaItem(id = 580, posterPath = "https://m.media-amazon.com/images/I/5151N2hUPiL._AC_UF894,1000_QL80_.jpg")
                   )
                   else -> emptyList()
               }.toHomeDataList()
           }
        }
    }

private fun List<ApiMediaItem>.toHomeDataList(): List<HomeData> {
    val homeDataList = mutableListOf<HomeData>()
    this.forEach {apiMediaItem ->
        homeDataList.add(
            HomeData(
                id = apiMediaItem.id,
                imagePath = apiMediaItem.posterPath
            )
        )
    }
    return homeDataList
}

