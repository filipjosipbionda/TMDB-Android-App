package hr.dice.filipbionda.tmdbpractice.ui.homescreen.presentation

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import hr.dice.filipbionda.tmdbpractice.R
import hr.dice.filipbionda.tmdbpractice.data.models.ContentType
import hr.dice.filipbionda.tmdbpractice.ui.homescreen.model.MediaItem
import hr.dice.filipbionda.tmdbpractice.ui.theme.TMDBPracticeTheme
import hr.dice.filipbionda.tmdbpractice.ui.theme.black_100
import hr.dice.filipbionda.tmdbpractice.ui.theme.grey_50
import hr.dice.filipbionda.tmdbpractice.ui.theme.lightPurple
import hr.dice.filipbionda.tmdbpractice.ui.theme.purple_36
import hr.dice.filipbionda.tmdbpractice.ui.theme.secondaryColor
import hr.dice.filipbionda.tmdbpractice.ui.theme.white
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val homeViewModel: HomeViewModel = viewModel()

    val currentCategory by homeViewModel.contentType.collectAsState()
    val mediaItems by homeViewModel.mediaItems.collectAsState()
    val popularMediaItems by homeViewModel.popularMediaItems.collectAsState()

    val brush =
        Brush.verticalGradient(
            colorStops =
            arrayOf(
                0.0f to lightPurple,
                0.6f to black_100,
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
            currentCategory = currentCategory,
            onChipClick = { category ->
                homeViewModel.setContentType(category)
            },
            categories = ContentType.entries.toList(),
            modifier = Modifier
                .offset(y = dimensionResource(R.dimen.home_screen_chip_group_y_offset))
                .zIndex(2f)
                .fillMaxWidth(),
        )
        HomeScreenContent(
            items = mediaItems,
            popularItems = popularMediaItems,
            modifier =
            Modifier
                .offset(y = dimensionResource(R.dimen.home_screen_content_y_offset))
                .zIndex(1f)
                .fillMaxSize(),
        )
    }
}

@Composable
private fun HomeScreenHeadline(modifier: Modifier = Modifier) {
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
                color = white,
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
private fun HomeScreenSearchBar(modifier: Modifier = Modifier) {
    var query by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val suggestions =
        rememberSaveable {
            mutableListOf(
                "Spider-man 2",
                "Batman",
            )
        }

    val animatedDp by animateDpAsState(
        targetValue = if (expanded) 0.dp else dimensionResource(R.dimen.home_screen_search_horizontal_padding),
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
                containerColor = purple_36,
            ),
            modifier =
            Modifier
                .fillMaxWidth()
                .height(dimensionResource(R.dimen.home_screen_search_bar_height))
                .offset(y = animatedYaxisOffset)
                .padding(horizontal = animatedDp),
            inputField = {
                SearchBarDefaults.InputField(
                    colors =
                    TextFieldDefaults.colors(
                        focusedTextColor = white,
                    ),
                    query = query,
                    onSearch = { suggestion ->
                        expanded = false
                        query = ""
                        if (suggestion.isNotEmpty()) {
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
                                color = grey_50,
                            ),
                        )
                    },
                    trailingIcon = {
                        if (expanded) {
                            IconButton(
                                onClick = {
                                    if (query.isEmpty()) {
                                        expanded = false
                                    } else {
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
                                tint = grey_50,
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
    currentCategory: ContentType,
) {
    var selectedChip by rememberSaveable {
        mutableStateOf(currentCategory)
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
                        if (category == categories.first()) {
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
                        style = if (category == selectedChip) {
                            MaterialTheme.typography.labelSmall
                        } else {
                            MaterialTheme.typography.labelSmall.copy(
                                color = grey_50,
                                fontWeight = FontWeight.Normal,
                            )
                        },
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
    items: List<MediaItem>,
    popularItems: List<MediaItem>,
    modifier: Modifier = Modifier,
) {
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
            modifier = Modifier.height(200.dp).fillMaxWidth()
        ) {
            items(
                items,
                key = {
                    it.id
                }
            ) {mediaItem ->
                AsyncImage(
                    model = mediaItem.imagePath,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier =
                    Modifier
                        .animateItem(
                            fadeInSpec = tween(durationMillis = 300),
                            fadeOutSpec = tween(300),
                        )
                        .padding(
                            start =
                            if (mediaItem == items.first()) {
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
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            Log.d("HomeScreen", items.size.toString())
            items(
                popularItems,
                key = {
                    it.id
                }
            ) {mediaItem ->
                AsyncImage(
                    model = mediaItem.imagePath,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier =
                    Modifier
                        .animateItem()
                        .padding(
                            start =
                            if (mediaItem == items.first()) {
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
