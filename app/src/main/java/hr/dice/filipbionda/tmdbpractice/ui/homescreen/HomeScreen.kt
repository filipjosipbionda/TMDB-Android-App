package hr.dice.filipbionda.tmdbpractice.ui.homescreen

import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import coil.compose.AsyncImage
import hr.dice.filipbionda.tmdbpractice.R
import hr.dice.filipbionda.tmdbpractice.data.models.ContentType
import hr.dice.filipbionda.tmdbpractice.ui.theme.TMDBPracticeTheme
import hr.dice.filipbionda.tmdbpractice.ui.theme.black_100
import hr.dice.filipbionda.tmdbpractice.ui.theme.purple_100
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch

private const val mockMovieUrl =
    "https://i.namu.wiki/i/__CjJoFpuzJXzMjM2DjQYvXCNf6UbCA_uaqgE5gubv80nATEJXEMwf01jV7kQnfkpREUrl2MEmR18H8_rUFAOg.webp"
private const val mockSeriesUrl =
    "https://m.media-amazon.com/images/M/MV5BYWFjYmMxMjMtMGE2ZC00YWZhLTgzNDYtYTA3ODA2MDg2NTA4XkEyXkFqcGc@._V1_.jpg"
private const val mockAnimeUrl =
    "https://u.livechart.me/anime/11850/poster_image/3531ac77e0fd178adc0875c1afa6ec16.webp/large.jpg"
private const val mockSoapsUrl =
    "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR7HTzLmKUtvWDRCj_IJWxJw8CayAM8lZ0W3Ago_B33RWT0KfwB"
private const val mockSpecialsUrl =
    "https://m.media-amazon.com/images/M/MV5BNzMyMTM1MjQxNF5BMl5BanBnXkFtZTgwMjY4NTE5NjE@._V1_.jpg"

private val mockMovies =
    listOf(
        "movie1",
        "movie2",
        "movie3",
        "movie4",
        "movie5",
        "movie6",
    )

private val mockSeries =
    listOf(
        "series1",
        "series2",
        "series3",
        "series4",
        "series5",
        "series6",
    )

private val mockAnime =
    listOf(
        "anime1",
        "anime2",
        "anime3",
        "anime4",
        "anime5",
        "anime6",
    )

private val mockSoaps =
    listOf(
        "soaps1",
        "soaps2",
        "soaps3",
        "soaps4",
        "soaps5",
        "soaps6",
    )

private val mockSpecials =
    listOf(
        "specials1",
        "specials2",
        "specials3",
        "specials4",
        "specials5",
        "specials6",
    )

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var currentCategory by rememberSaveable {
        mutableStateOf(ContentType.MOVIE)
    }

    val lazyListState = rememberLazyListState()

    val currentItems =
        when (currentCategory) {
            ContentType.MOVIE -> mockMovies
            ContentType.SERIES -> mockSeries
            ContentType.ANIME -> mockAnime
            ContentType.SOAPS -> mockSoaps
            ContentType.SPECIALS -> mockSpecials
        }

    val brush =
        Brush.verticalGradient(
            colorStops =
            arrayOf(
                0.0f to purple_100,
                0.6f to black_100,
            ),
        )

    LazyColumn(
        state = lazyListState,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .background(
                brush = brush,
            ),
    ) {
        item {
            Spacer(
                modifier = Modifier.height(dimensionResource(R.dimen.home_screen_spacer_64)),
            )
        }
        item {
            HomeScreenHeadline(
                modifier = Modifier.fillMaxWidth(),
            )
        }
        item {
            Spacer(
                modifier = Modifier.height(dimensionResource(R.dimen.home_screen_spacer_20)),
            )
        }
        item {
            HomeScreenSearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.home_screen_search_bar_height))
                    .padding(horizontal = dimensionResource(R.dimen.home_screen_horizontal_padding)),
                onClick = {},
            )
        }
        item {
            Spacer(
                modifier = Modifier.height(dimensionResource(R.dimen.home_screen_spacer_36)),
            )
        }
        item {
            HomeScreenChipGroup(
                onChipClick = { category ->
                    currentCategory = category
                },
                categories = ContentType.entries.toImmutableList(),
                modifier =
                Modifier
                    .fillMaxWidth(),
            )
        }
        item {
            Spacer(
                modifier = Modifier.height(dimensionResource(R.dimen.home_screen_spacer_36)),
            )
        }
        item {
            HomeScreenContent(
                items = currentItems.toImmutableList(),
                popularItems = currentItems.toImmutableList(),
            )
        }
    }
}

@Composable
private fun HomeScreenHeadline(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
        modifier =
        modifier
            .padding(
                horizontal = dimensionResource(R.dimen.home_screen_horizontal_padding),
            ),
    ) {
        Text(
            text = stringResource(R.string.headline_text),
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
            ),
        )
        Box(
            modifier =
            Modifier
                .padding(top = dimensionResource(R.dimen.home_screen_headline_image_padding_top))
                .size(dimensionResource(R.dimen.home_screen_headline_image_size))
                .background(MaterialTheme.colorScheme.onBackground)
                .clip(shape = CircleShape)
                .border(
                    border =
                    BorderStroke(
                        width = dimensionResource(R.dimen.home_screen_headline_image_border_width),
                        color = MaterialTheme.colorScheme.onSurface,
                    ),
                    shape = CircleShape,
                ),
        ) {
            Image(
                painter = painterResource(R.drawable.profile_picture),
                contentDescription = stringResource(R.string.profile_picture_content_description),
                contentScale = ContentScale.FillBounds,
            )
        }
    }
}

@Composable
private fun HomeScreenSearchBar(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.search),
                style = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.surfaceBright,
                ),
            )
            Icon(
                imageVector = Icons.Default.Search,
                tint = MaterialTheme.colorScheme.surfaceBright,
                contentDescription = null,
            )
        }
    }
}

@Composable
fun HomeScreenChipGroup(
    categories: ImmutableList<ContentType>,
    onChipClick: (ContentType) -> Unit,
    modifier: Modifier = Modifier,
    initialCategory: ContentType = ContentType.MOVIE,
) {
    var selectedChip by rememberSaveable {
        mutableStateOf(initialCategory)
    }
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.filter_chip_group_content_padding)),
        modifier = modifier,
    ) {
        item {
            Spacer(
                modifier = Modifier.width(dimensionResource(R.dimen.filter_chip_group_spacer_width)),
            )
        }
        items(categories) { category ->
            FilterChip(
                modifier = Modifier
                    .height(dimensionResource(R.dimen.filter_chip_height))
                    .width(dimensionResource(R.dimen.filter_chip_width)),
                selected = selectedChip == category,
                shape = RoundedCornerShape(dimensionResource(R.dimen.filter_chip_shape_size)),
                border = null,
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.secondary,
                    selectedLabelColor = MaterialTheme.colorScheme.secondary,
                    disabledLabelColor = MaterialTheme.colorScheme.onSurface,
                    disabledSelectedContainerColor = MaterialTheme.colorScheme.onBackground,
                ),
                onClick = {
                    selectedChip = category
                    onChipClick(selectedChip)
                },
                label = {
                    Text(
                        text = createChipLabel(category),
                        style = if (category == selectedChip) {
                            MaterialTheme.typography.labelSmall.copy(
                                textAlign = TextAlign.Center,
                            )
                        } else {
                            MaterialTheme.typography.labelSmall.copy(
                                color = MaterialTheme.colorScheme.surfaceBright,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center,
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                    )
                },
            )
        }
        item {
            Spacer(
                modifier = Modifier.width(dimensionResource(R.dimen.filter_chip_group_spacer_width)),
            )
        }
    }
}

@Composable
fun HomeScreenContent(
    items: ImmutableList<String>,
    popularItems: ImmutableList<String>,
    modifier: Modifier = Modifier,
) {
    val mockImage =
        when (items.first()) {
            "movie1" -> mockMovieUrl
            "series1" -> mockSeriesUrl
            "anime1" -> mockAnimeUrl
            "soaps1" -> mockSoapsUrl
            "specials1" -> mockSpecialsUrl
            else -> throw IllegalArgumentException()
        }
    val itemsLazyRowState = rememberLazyListState()
    val popularItemsLazyRowState = rememberLazyListState()

    LaunchedEffect(items, popularItems) {
        launch {
            launch { itemsLazyRowState.animateScrollToItem(0) }
            launch { popularItemsLazyRowState.animateScrollToItem(0) }
        }
    }

    Column(
        modifier = modifier,
    ) {
        LazyRow(
            state = itemsLazyRowState,
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.home_screen_content_items_padding)),
        ) {
            item {
                Spacer(
                    modifier = Modifier.width(dimensionResource(R.dimen.home_screen_content_spacer_width)),
                )
            }
            items(
                items,
            ) {
                AsyncImage(
                    model = mockImage,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    placeholder = painterResource(R.drawable.placeholder_image),
                    modifier =
                    Modifier
                        .animateItem(
                            fadeInSpec = tween(durationMillis = 300),
                            fadeOutSpec = tween(300),
                        )
                        .height(dimensionResource(R.dimen.content_image_height))
                        .width(dimensionResource(R.dimen.content_image_width))
                        .clip(shape = RoundedCornerShape(size = dimensionResource(R.dimen.content_image_shape_size))),
                )
            }
            item {
                Spacer(
                    modifier = Modifier.width(dimensionResource(R.dimen.home_screen_content_spacer_width)),
                )
            }
        }
        Spacer(
            modifier = Modifier.height(dimensionResource(R.dimen.home_screen_content_vertical_padding)),
        )
        Text(
            text = "Most popular",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = dimensionResource(R.dimen.home_screen_horizontal_padding)),
        )
        Spacer(
            modifier = Modifier.height(dimensionResource(R.dimen.home_screen_content_vertical_padding)),
        )
        LazyRow(
            state = popularItemsLazyRowState,
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.home_screen_content_items_padding)),
        ) {
            item {
                Spacer(
                    modifier = Modifier.width(dimensionResource(R.dimen.home_screen_content_spacer_width)),
                )
            }
            items(popularItems) {
                AsyncImage(
                    model = mockImage,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    placeholder = painterResource(R.drawable.placeholder_image),
                    modifier =
                    Modifier
                        .animateItem()
                        .height(dimensionResource(R.dimen.content_image_height))
                        .width(dimensionResource(R.dimen.content_image_width))
                        .clip(shape = RoundedCornerShape(size = dimensionResource(R.dimen.content_image_shape_size))),
                )
            }
            item {
                Spacer(
                    modifier = Modifier.width(dimensionResource(R.dimen.home_screen_content_spacer_width)),
                )
            }
        }
    }
}

@Composable
fun createChipLabel(contentType: ContentType): String {
    return when (contentType) {
        ContentType.MOVIE -> stringResource(R.string.movies)
        ContentType.SERIES -> stringResource(R.string.series)
        ContentType.ANIME -> stringResource(R.string.anime)
        ContentType.SOAPS -> stringResource(R.string.soaps)
        ContentType.SPECIALS -> stringResource(R.string.specials)
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    TMDBPracticeTheme {
        HomeScreen()
    }
}
