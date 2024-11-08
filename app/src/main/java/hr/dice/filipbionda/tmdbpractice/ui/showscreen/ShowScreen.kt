package hr.dice.filipbionda.tmdbpractice.ui.showscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import hr.dice.filipbionda.tmdbpractice.R
import hr.dice.filipbionda.tmdbpractice.data.mocks.mockMovies
import hr.dice.filipbionda.tmdbpractice.data.models.Actor
import hr.dice.filipbionda.tmdbpractice.data.models.MediaItem
import hr.dice.filipbionda.tmdbpractice.ui.components.ExpandedButton
import hr.dice.filipbionda.tmdbpractice.ui.theme.TMDBPracticeTheme
import hr.dice.filipbionda.tmdbpractice.ui.theme.black_21
import hr.dice.filipbionda.tmdbpractice.ui.theme.white_CC
import java.time.LocalDate
import java.time.format.DateTimeFormatter

val mockMovie = MediaItem(
    title = "Inception",
    rating = 87,
    coverPath = "https://im.jdmagicbox.com/comp/jd_social/news/2021dec11/image-1092864-84qgkwd5wz.jpg?clr=#382e38",
    date = "21/07/2022",
    language = "EN",
    overview = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
    actors = listOf(
        Actor(name = "Leonardo", surname = "DiCaprio" ,imagePath = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8yhDDv3b5ixR0-eeKOz9sfth6qlJxUFRuMk3fRJktRUVlO4fJ"),
        Actor(name = "Joseph", surname = "Gordon-Levitt", imagePath = "https://m.media-amazon.com/images/M/MV5BMTY3NTk0NDI3Ml5BMl5BanBnXkFtZTgwNDA3NjY0MjE@._V1_.jpg"),
        Actor(name = "Ellen", surname = "Page", imagePath = "https://resizing.flixster.com/VsatQP6O9THxjHuKRsWwXjtPBAg=/fit-in/352x330/v2/http://media.baselineresearch.com/images/1260564/1260564_full.jpg")
    ),
    categories = listOf("Action", "Sci-Fi", "Thriller", "Anime", "Sports", "Specials"),
    duration = 140,
    seasons = null,
    trailerUrl = ""
)

@Composable
fun ShowScreen(mediaItem: MediaItem,navigateBack: () -> Unit, openRecommendedMediaItem: (MediaItem) -> Unit, playTrailer: (String) -> Unit ,modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = black_21)
    ){
        val columnState = rememberScrollState()
        ShowScreenAppBar(
            navigateBack = navigateBack,
            addToFavorites = {
                // TODO - cache MediaItem
            },
            modifier = Modifier
                .offset(y = dimensionResource(R.dimen.app_bar_y_offset))
                .padding(end = dimensionResource(R.dimen.show_screen_horizontal_padding))
                .zIndex(1f)
                .fillMaxWidth()
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surfaceContainer)
                .verticalScroll(
                    state = columnState,
                )
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center

            ) {
                ShowScreenCoverImage(
                   imagePath = mediaItem.coverPath,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                )
                ShowScreenMediaBasicInfo(
                    title = mockMovie.title,
                    date = mockMovie.date,
                    language = mockMovie.language,
                    progress = mockMovie.rating,
                    duration = getMinutesString(mockMovie.duration),
                    seasons = null,
                    modifier = Modifier
                        .align(alignment = Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.show_screen_horizontal_padding))

                )
            }
            Spacer(
                modifier = Modifier.height(dimensionResource(R.dimen.show_screen_spacer_height_1))
            )
            HorizontalDivider(
                thickness = dimensionResource(R.dimen.horizontal_divider_thickness),
                color = MaterialTheme.colorScheme.scrim,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.show_screen_horizontal_padding))
            )
            Spacer(
                modifier = Modifier.height(dimensionResource(R.dimen.show_screen_spacer_height_1))
            )
            Text(
                text = mockMovie.overview,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = white_CC,
                    lineHeight = 16.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.show_screen_horizontal_padding))
            )
            Spacer(
                modifier = Modifier.height(dimensionResource(R.dimen.show_screen_spacer_height_2))
            )
            ExpandedButton(
                onClick = {
                    playTrailer(mockMovie.trailerUrl)
                },
                modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.show_screen_horizontal_padding)),
                content = {
                    Row {
                        Icon(
                            imageVector = Icons.Outlined.PlayCircle,
                            contentDescription = null
                        )
                        Spacer(
                            modifier = Modifier.width(dimensionResource(R.dimen.play_trailer_items_padding))
                        )
                        Text(
                            text = stringResource(R.string.play_trailer)
                        )
                    }
                }
            )
            Spacer(
                modifier = Modifier.height(dimensionResource(R.dimen.show_screen_spacer_height_3))
            )
            Text(
                text = stringResource(R.string.main_actors),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = dimensionResource(R.dimen.home_screen_horizontal_padding))
            )
            Spacer(
                modifier = Modifier.height(dimensionResource(R.dimen.show_screen_spacer_height_1))
            )
            ShowScreenMainActors(
                actors = mockMovie.actors,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(
                modifier = Modifier.height(dimensionResource(R.dimen.show_screen_spacer_height_3))
            )
            Text(
                text = setCategoryString(mockMovie.categories.count()),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = dimensionResource(R.dimen.show_screen_horizontal_padding))
            )
            Spacer(
                modifier = Modifier.height(dimensionResource(R.dimen.show_screen_spacer_height_1))
            )
            ShowScreenCategories(
                categories = mockMovie.categories
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.show_screen_spacer_height_3)))
            Text(
                text = stringResource(R.string.recommended),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = dimensionResource(R.dimen.home_screen_horizontal_padding))
            )
            Spacer(
                modifier = Modifier.height(dimensionResource(R.dimen.show_screen_spacer_height_1))
            )
            ShowScreenRecommendedMediaItems(
                recommendedMediaItems = mockMovies,
                openRecommendedMediaItem = {
                    openRecommendedMediaItem(it)
                }
            )
            Spacer(
                modifier = Modifier.height(dimensionResource(R.dimen.show_screen_spacer_end))
            )
        }
    }
}

@Composable
private fun ShowScreenAppBar(navigateBack: () -> Unit, addToFavorites: () -> Unit, modifier: Modifier = Modifier){
    Row(
        modifier = modifier.background(color = MaterialTheme.colorScheme.onBackground),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = navigateBack
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(dimensionResource(R.dimen.show_screen_app_bar_navigation_icon_size))
                )
            }
            Spacer(
                modifier = Modifier.width(dimensionResource(R.dimen.show_screen_app_bar_spacer_height_1))
            )
            Text(
                text = "Go back",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
        }
            IconButton(
                onClick = addToFavorites,
                modifier = Modifier
                    .background(
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.onTertiary
                )
                    .size(dimensionResource(R.dimen.show_screen_app_bar_icon_button_size))
            ) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(R.dimen.show_screen_app_bar_favorite_icon_size))
                )
            }
    }
}

@Composable
private fun ShowScreenCoverImage(imagePath: String, modifier: Modifier = Modifier){
     val brush =
        Brush.verticalGradient(
            colorStops =
            arrayOf(
                0.0f to MaterialTheme.colorScheme.onBackground,
                0.95f to MaterialTheme.colorScheme.surfaceContainer,
            ),
        )

    Box(
        modifier = modifier
    ){
        AsyncImage(
            model = imagePath,
            modifier = Modifier.fillMaxSize(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.placeholder_image)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = brush)
        )
    }
}

@Composable
private fun ShowScreenMediaBasicInfo(title:String, date:String, language:String, progress: Int, duration: String?, seasons:Int?, modifier: Modifier = Modifier) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                progress = { progress/100f},
                modifier = Modifier.size(72.dp),
                trackColor = MaterialTheme.colorScheme.secondaryContainer,
                color = MaterialTheme.colorScheme.secondary,
                strokeWidth = dimensionResource(R.dimen.circular_progress_indicator_stroke_width)
            )
            Text(
                text = "$progress%",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(
            modifier = Modifier.width(dimensionResource(R.dimen.show_screen_media_info_spacer_width_1))
        )
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            val year = getYearFromDateString(date)
            Text(
                text = "$title ($year)",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 24.sp,
                ),
                maxLines = 1
            )
            Spacer(
                modifier = Modifier.height(dimensionResource(R.dimen.show_screen_media_info_spacer_height_1))
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$date ($language)",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )
                Spacer(
                    modifier = Modifier.width(dimensionResource(R.dimen.show_screen_media_info_spacer_width_2))
                )
                if (duration!=null){
                        MediaItemDuration(
                            durationString = duration
                        )
                    }else if(seasons!=null){
                        MediaItemDuration(
                            durationString = stringResource(R.string.seasons_count, seasons)
                        )
                }
            }
        }
    }
}

@Composable
private fun MediaItemDuration(durationString: String, modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ){
        Icon(
            imageVector = Icons.Default.Circle,
            contentDescription = null,
            modifier = Modifier.size(dimensionResource(R.dimen.media_item_duration_dot_icon_size)),
            tint = MaterialTheme.colorScheme.onSurface
        )
        Spacer(
            modifier = Modifier.width(dimensionResource(R.dimen.media_item_duration_spacer_width_1))
        )
        Icon(
            imageVector = Icons.Outlined.AccessTime,
            contentDescription = null,
            modifier = Modifier.size(dimensionResource(R.dimen.media_item_duration_access_time_icon_size)),
            tint = MaterialTheme.colorScheme.onSurface
        )
        Spacer(
            modifier = Modifier.width(dimensionResource(R.dimen.media_item_duration_spacer_width_1))
        )
        Text(
            text = durationString,
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface,
            )
        )
    }
}

@Composable
private fun ShowScreenMainActors(actors: List<Actor>, modifier: Modifier = Modifier) {

    LazyRow(
        modifier = modifier
    ) {
        items(actors) { actor ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = if(actor == actors.first()) dimensionResource(R.dimen.show_screen_horizontal_padding) else dimensionResource(R.dimen.show_screen_main_actors_items_padding))
            ) {
                AsyncImage(
                    model = actor.imagePath,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.show_screen_main_actors_item_size))
                        .border(
                            width = dimensionResource(R.dimen.show_screen_main_actors_item_border_width),
                            color = MaterialTheme.colorScheme.tertiaryContainer,
                            shape = CircleShape
                        )
                        .clip(CircleShape),
                    contentDescription = null,
                    placeholder = painterResource(R.drawable.placeholder_image)
                )
                Spacer(
                    modifier = Modifier.height(dimensionResource(R.dimen.show_screen_main_actors_spacer_height))
                )
                Text(
                    text = stringResource(R.string.actor_text, actor.name, actor.surname),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 12.sp
                    ),
                )
            }
        }
    }
}

@Composable
private fun ShowScreenCategories(categories: List<String>, modifier: Modifier = Modifier){

        LazyRow(
            modifier = modifier,
        ){
            items(categories){category ->
                FilterChip(
                    enabled = false,
                    onClick = {},
                    label = {
                        Text(
                            text = category,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontWeight = FontWeight.Medium
                            )
                        )
                    },
                    selected = true,
                    colors = FilterChipDefaults.filterChipColors(
                        disabledSelectedContainerColor = MaterialTheme.colorScheme.tertiaryContainer
                    ),
                    shape = RoundedCornerShape(size = dimensionResource(R.dimen.show_screen_categories_shape_size)),
                    modifier = Modifier.padding(
                        start = if(category == categories.first()) dimensionResource(R.dimen.show_screen_horizontal_padding) else dimensionResource(R.dimen.show_screen_categories_items_padding_start))
                )
            }
        }
}

@Composable
private fun ShowScreenRecommendedMediaItems(recommendedMediaItems: List<MediaItem>, openRecommendedMediaItem: (MediaItem) -> Unit, modifier: Modifier = Modifier){
    LazyRow(
        modifier = modifier
    ) {
        items(recommendedMediaItems){mediaItem ->
            AsyncImage(
                model = mediaItem.coverPath,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                placeholder = painterResource(R.drawable.placeholder_image),
                modifier = Modifier
                    .padding(
                        start =
                        if (mediaItem == recommendedMediaItems.first()) {
                            dimensionResource(
                                R.dimen.home_screen_horizontal_padding,
                            )
                        } else {
                            dimensionResource(R.dimen.home_screen_content_image_padding_start)
                        },
                    )
                    .height(dimensionResource(R.dimen.content_image_height))
                    .width(dimensionResource(R.dimen.content_image_width))
                    .clip(shape = RoundedCornerShape(size = dimensionResource(R.dimen.content_image_shape_size)))
                    .clickable {
                        openRecommendedMediaItem(mediaItem)
                    },
            )
        }
    }
}

@Preview
@Composable
private fun ShowScreenAppBarPreview(){
    TMDBPracticeTheme {
        ShowScreenAppBar(
            modifier = Modifier.fillMaxWidth(),
            navigateBack = {},
            addToFavorites = {},
        )
    }
}

@Preview
@Composable
private fun ShowScreenPreview() {
    TMDBPracticeTheme {
        ShowScreen(
            navigateBack = {},
            openRecommendedMediaItem = {},
            mediaItem = mockMovie,
            playTrailer = {}
        )
    }
}

@Preview
@Composable
private fun ShowScreenCoverImagePreview() {
    TMDBPracticeTheme {
        ShowScreenCoverImage(
            imagePath = mockMovie.coverPath
        )
    }
}

@Preview
@Composable
private fun ShowScreenMediaBasicInfoPreview(){
    TMDBPracticeTheme {
        ShowScreenMediaBasicInfo(
            progress = 75,
            date = "10/12/2021",
            title = "The Unforgivable",
            language = "BR",
            duration = "1h 23m",
            seasons = null
        )
    }
}
@Preview
@Composable
private fun MediaItemDurationPreview(){
    TMDBPracticeTheme {
        MediaItemDuration(
            durationString = "1h 53m"
        )
    }
}

@Preview
@Composable
private fun ShowScreenMainActorsPreview(){
    TMDBPracticeTheme {
        ShowScreenMainActors(
            actors = mockMovie.actors
        )
    }
}

@Preview
@Composable
private fun ShowScreenCategoriesPreview(){
    TMDBPracticeTheme {
        ShowScreenCategories(
            categories = mockMovie.categories
        )
    }
}

@Preview
@Composable
private fun ShowScreenRecommendedMediaItem(){
    ShowScreenRecommendedMediaItems(
        recommendedMediaItems = mockMovies,
        openRecommendedMediaItem = {}
    )
}


private fun getYearFromDateString(dateString: String): String {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val date = LocalDate.parse(dateString, formatter)
    return date.year.toString()
}

@Composable
private fun getMinutesString(minutes: Long?): String? {
    val hours = minutes?.div(60)
    val remainingMinutes = minutes?.rem(60)
    if (hours != null && remainingMinutes!=null) {
        return when {
            hours > 0 && remainingMinutes > 0 -> stringResource(
                R.string.hours_minutes,
                hours,
                remainingMinutes
            )

            hours > 0 -> stringResource(R.string.hours, hours)
            else -> stringResource(R.string.minutes, remainingMinutes)
        }
    }
    return null
}

@Composable
private fun setCategoryString(categoriesCount: Int): String {
    return when{
        categoriesCount>1 -> "Categories"
        else -> "Category"
    }
}
