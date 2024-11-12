package hr.dice.filipbionda.tmdbpractice.ui.homescreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hr.dice.filipbionda.tmdbpractice.data.models.ContentType
import hr.dice.filipbionda.tmdbpractice.ui.homescreen.di.HomeObjectGraph
import hr.dice.filipbionda.tmdbpractice.ui.homescreen.domain.GetHomeData
import hr.dice.filipbionda.tmdbpractice.ui.homescreen.domain.GetPopularHomeData
import hr.dice.filipbionda.tmdbpractice.ui.homescreen.domain.model.HomeData
import hr.dice.filipbionda.tmdbpractice.ui.homescreen.model.MediaItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    val getHomeData: GetHomeData = HomeObjectGraph.getHomeData(),
    val getPopularHomeData: GetPopularHomeData = HomeObjectGraph.getPopularHomeData()
) : ViewModel() {
    private val _contentType = MutableStateFlow(ContentType.MOVIE)
    val contentType = _contentType.asStateFlow()

    private val _mediaItems = MutableStateFlow<List<MediaItem>>(emptyList())
    val mediaItems = _mediaItems.asStateFlow()

    private val _popularMediaItems = MutableStateFlow<List<MediaItem>>(emptyList())
    val popularMediaItems = _popularMediaItems.asStateFlow()


    init {
        viewModelScope.launch { 
            contentType.collect{ contentType ->
                loadMediaItems(contentType)
                loadPopularMediaItems(contentType)   
            }
        }
    }


   private suspend fun loadMediaItems(contentType: ContentType) {
            _mediaItems.value = getHomeData(contentType).toMediaItemList()
    }

   private  suspend fun loadPopularMediaItems(contentType: ContentType) {
            _popularMediaItems.value = getPopularHomeData(contentType).toMediaItemList()
    }
    
   fun setContentType(contentType: ContentType) {
       _contentType.value = contentType
   } 
}

private fun List<HomeData>.toMediaItemList(): List<MediaItem> {
    val mediaItemList = mutableListOf<MediaItem>()
    this.forEach { homeData ->
        mediaItemList.add(
            MediaItem(
                id = homeData.id,
                imagePath = homeData.imagePath
            )
        )
    }
    return mediaItemList.toList()
}

