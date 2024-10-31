package hr.dice.filipbionda.tmdbpractice.ui.homescreen

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateDpAsState
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
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
import hr.dice.filipbionda.tmdbpractice.data.models.ContentType
import hr.dice.filipbionda.tmdbpractice.ui.theme.TMDBPracticeTheme
import hr.dice.filipbionda.tmdbpractice.ui.theme.homeScreenBackgroundFirstColor
import hr.dice.filipbionda.tmdbpractice.ui.theme.homeScreenBackgroundSecondColor
import hr.dice.filipbionda.tmdbpractice.ui.theme.homeScreenHeadlineTextColor
import hr.dice.filipbionda.tmdbpractice.ui.theme.searchBarContainerColor
import hr.dice.filipbionda.tmdbpractice.ui.theme.searchBarContentColor
import hr.dice.filipbionda.tmdbpractice.ui.theme.secondaryColor
import kotlinx.coroutines.launch

private const val mockMovieUrl = "https://i.namu.wiki/i/__CjJoFpuzJXzMjM2DjQYvXCNf6UbCA_uaqgE5gubv80nATEJXEMwf01jV7kQnfkpREUrl2MEmR18H8_rUFAOg.webp"
private const val mockSeriesUrl = "https://m.media-amazon.com/images/M/MV5BYWFjYmMxMjMtMGE2ZC00YWZhLTgzNDYtYTA3ODA2MDg2NTA4XkEyXkFqcGc@._V1_.jpg"
private const val mockAnimeUrl = "https://u.livechart.me/anime/11850/poster_image/3531ac77e0fd178adc0875c1afa6ec16.webp/large.jpg"
private const val mockSoapsUrl = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR7HTzLmKUtvWDRCj_IJWxJw8CayAM8lZ0W3Ago_B33RWT0KfwB"
private const val mockSpecialsUrl = "https://m.media-amazon.com/images/M/MV5BNzMyMTM1MjQxNF5BMl5BanBnXkFtZTgwMjY4NTE5NjE@._V1_.jpg"

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
fun HomeScreen(modifier: Modifier = Modifier)  {
    var currentCategory by rememberSaveable {
        mutableStateOf(ContentType.MOVIE)
    }

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
                    0.0f to homeScreenBackgroundFirstColor,
                    0.6f to homeScreenBackgroundSecondColor,
                ),
        )

    Box(
        modifier =
            modifier
                .fillMaxSize()
                .background(
                    brush = brush,
                ),
    ) {
        HomeScreenHeadline(
            modifier = Modifier.offset(y = dimensionResource(R.dimen.home_screen_headline_y_offset)),
        )
        HomeScreenSearchBar(
            modifier = Modifier.zIndex(3f),
        )

        HomeScreenChipGroup(
            onChipClick = { category ->
                currentCategory = category
            },
            categories = ContentType.entries.toList(),
            modifier =
                Modifier
                    .offset(y = dimensionResource(R.dimen.home_screen_chip_group_y_offset))
                    .zIndex(2f)
                    .fillMaxWidth(),
        )
        HomeScreenContent(
            items = currentItems,
            popularItems = currentItems,
            modifier =
                Modifier
                    .offset(y = dimensionResource(R.dimen.home_screen_content_y_offset))
                    .zIndex(1f)
                    .fillMaxSize(),
        )
    }
}

@Composable
private fun HomeScreenHeadline(modifier: Modifier = Modifier)  {
    Column(
        modifier = modifier,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = dimensionResource(R.dimen.home_screen_horizontal_padding),
                    ),
        ) {
            Text(
                text = "What do you want to\nwatch today?",
                color = homeScreenHeadlineTextColor,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.height(height = dimensionResource(R.dimen.home_screen_headline_text_height)),
            )
            Box(
                modifier =
                    Modifier
                        .padding(top = dimensionResource(R.dimen.home_screen_headline_image_padding_top))
                        .size(dimensionResource(R.dimen.home_screen_headline_image_size))
                        .background(Color.Transparent)
                        .clip(shape = CircleShape)
                        .border(
                            border =
                                BorderStroke(
                                    width = dimensionResource(R.dimen.home_screen_headline_image_border_width),
                                    color = Color.White,
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
}

@SuppressLint("UseOfNonLambdaOffsetOverload")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreenSearchBar(modifier: Modifier = Modifier)  {
    var query by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val suggestions =
        rememberSaveable {
            mutableListOf(
                "Spider-man 2",
                "Batman",
            )
        }
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    val animatedWidth by animateDpAsState(
        targetValue = if (expanded) screenWidth else dimensionResource(R.dimen.home_screen_search_bar_width),
        animationSpec =
            tween(
                durationMillis = 400,
                easing = FastOutLinearInEasing,
            ),
        label = "",
    )

    val animatedXaxisOffset by animateDpAsState(
        targetValue = if (expanded) 0.dp else dimensionResource(R.dimen.home_screen_search_bar_x_offset),
        animationSpec =
            tween(
                durationMillis = 400,
                easing = FastOutLinearInEasing,
            ),
        label = "",
    )

    val animatedYaxisOffset by animateDpAsState(
        targetValue = if (expanded) 0.dp else dimensionResource(R.dimen.home_screen_search_bar_y_offset),
        animationSpec =
            tween(
                durationMillis = 400,
                easing = FastOutLinearInEasing,
            ),
        label = "",
    )

    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        SearchBar(
            colors =
                SearchBarDefaults.colors(
                    containerColor = searchBarContainerColor,
                ),
            modifier =
                Modifier
                    .width(animatedWidth)
                    .offset(y = animatedYaxisOffset, x = animatedXaxisOffset),
            inputField = {
                SearchBarDefaults.InputField(
                    colors =
                        TextFieldDefaults.colors(
                            focusedTextColor = homeScreenHeadlineTextColor,
                        ),
                    query = query,
                    onSearch = { suggestion ->
                        expanded = false
                        query = ""
                        if (suggestion.isNotEmpty())
                            {
                                suggestions.add(suggestion)
                            }
                    },
                    onQueryChange = {
                        query = it
                    },
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = it
                    },
                    placeholder = {
                        Text(
                            text = "Search...",
                            style =
                                MaterialTheme.typography.bodySmall.copy(
                                    fontSize = 16.sp,
                                    color = searchBarContentColor,
                                ),
                        )
                    },
                    trailingIcon = {
                        if (expanded)
                            {
                                IconButton(
                                    onClick = {
                                        if (query.isEmpty())
                                            {
                                                expanded = false
                                            } else
                                            {
                                                query = ""
                                            }
                                    },
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Clear,
                                        contentDescription = null,
                                    )
                                }
                            } else {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                tint = searchBarContentColor,
                            )
                        }
                    },
                )
            },
            expanded = expanded,
            onExpandedChange = {
                expanded = it
            },
        ) {
            LazyColumn(
                modifier = Modifier.padding(top = 10.dp),
            ) {
                items(suggestions) { suggestion ->
                    Row(
                        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.search_bar_suggestions_top_padding)),
                    ) {
                        Icon(
                            imageVector = Icons.Default.History,
                            tint = Color.White,
                            contentDescription = null,
                        )
                        Spacer(
                            modifier = Modifier.width(dimensionResource(R.dimen.search_bar_suggestion_content_padding)),
                        )
                        Text(
                            text = suggestion,
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreenChipGroup(
    categories: List<ContentType>,
    onChipClick: (ContentType) -> Unit,
    modifier: Modifier = Modifier,
    initialCategory: ContentType = ContentType.MOVIE,
)  {
    var selectedChip by rememberSaveable {
        mutableStateOf(initialCategory)
    }
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier =
            modifier
                .fillMaxWidth(),
    ) {
        items(categories) { category ->
            FilterChip(
                modifier =
                    Modifier
                        .padding(
                            start =
                                if (category == initialCategory) {
                                    dimensionResource(
                                        R.dimen.home_screen_horizontal_padding,
                                    )
                                } else {
                                    dimensionResource(R.dimen.filter_chip_group_content_padding)
                                },
                        )
                        .height(30.dp)
                        .width(90.dp),
                selected = selectedChip == category,
                shape = RoundedCornerShape(dimensionResource(R.dimen.filter_chip_shape_size)),
                border = null,
                colors =
                    FilterChipDefaults.filterChipColors(
                        selectedContainerColor = secondaryColor,
                        selectedLabelColor = MaterialTheme.typography.labelSmall.color,
                        disabledLabelColor = Color.White,
                        disabledSelectedContainerColor = Color.Transparent,
                    ),
                onClick = {
                    selectedChip = category
                    onChipClick(selectedChip)
                },
                label = {
                    Text(
                        text = createChipLabel(category),
                        style = if (category == selectedChip) MaterialTheme.typography.labelSmall else MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                    )
                },
            )
        }
    }
}

@Composable
fun HomeScreenContent(
    items: List<String>,
    popularItems: List<String>,
    modifier: Modifier = Modifier,
)  {
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
            listOf(
                launch { itemsLazyRowState.animateScrollToItem(0) },
                launch { popularItemsLazyRowState.animateScrollToItem(0) },
            ).forEach { it.join() }
        }
    }

    Column(
        modifier = modifier,
    ) {
        LazyRow(
            state = itemsLazyRowState,
        ) {
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
                            .padding(
                                start =
                                    if (it == items.first()) {
                                        dimensionResource(
                                            R.dimen.home_screen_horizontal_padding,
                                        )
                                    } else {
                                        dimensionResource(R.dimen.home_screen_content_image_padding_start)
                                    },
                            )
                            .height(dimensionResource(R.dimen.content_image_height))
                            .width(dimensionResource(R.dimen.content_image_width))
                            .clip(shape = RoundedCornerShape(size = dimensionResource(R.dimen.content_image_shape_size))),
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
        ) {
            items(popularItems) {
                AsyncImage(
                    model = mockImage,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    placeholder = painterResource(R.drawable.placeholder_image),
                    modifier =
                        Modifier
                            .animateItem()
                            .padding(
                                start =
                                    if (it == items.first()) {
                                        dimensionResource(
                                            R.dimen.home_screen_horizontal_padding,
                                        )
                                    } else {
                                        dimensionResource(R.dimen.home_screen_content_image_padding_start)
                                    },
                            )
                            .height(dimensionResource(R.dimen.content_image_height))
                            .width(dimensionResource(R.dimen.content_image_width))
                            .clip(shape = RoundedCornerShape(size = dimensionResource(R.dimen.content_image_shape_size))),
                )
            }
        }
    }
}

@Composable
fun createChipLabel(contentType: ContentType): String  {
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
fun HomeScreenPreview()  {
    TMDBPracticeTheme {
        HomeScreen()
    }
}
