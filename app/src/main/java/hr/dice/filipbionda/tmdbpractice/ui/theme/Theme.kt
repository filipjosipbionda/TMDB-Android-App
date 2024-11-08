package hr.dice.filipbionda.tmdbpractice.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme =
    lightColorScheme(
        primary = lightPurple,
        secondary = secondaryColor,
        tertiary = purple_54,
        onBackground = transparent,
        scrim = black_70,
        surfaceContainer = black_21,
        secondaryContainer = gray_30,
        onSurface = gray_BB,
        tertiaryContainer = gray_303,
        onPrimary = white,
        onTertiary = gray_303_transparent
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
