package hr.dice.filipbionda.tmdbpractice.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme =
    lightColorScheme(
        primary = purple_100,
        secondary = pink_138,
        tertiary = purple_54,
        secondaryContainer = purple_36,
        surfaceBright = grey_50,
        onBackground = transparent,
        scrim = black_70,
        onSurface = white,
    )

@Composable
fun TMDBPracticeTheme(
    content: @Composable () -> Unit,
) {
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}
