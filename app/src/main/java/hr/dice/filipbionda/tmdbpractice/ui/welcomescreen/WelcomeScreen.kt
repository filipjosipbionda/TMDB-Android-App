package hr.dice.filipbionda.tmdbpractice.ui.welcomescreen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import hr.dice.filipbionda.tmdbpractice.R
import hr.dice.filipbionda.tmdbpractice.ui.theme.TMDBPracticeTheme

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        BackgroundImage()
        WelcomeScreenContent(modifier = Modifier.align(alignment = Alignment.BottomCenter))
    }
}

@Composable
private fun BackgroundImage(modifier: Modifier = Modifier) {
    val brush =
        Brush.verticalGradient(
            colorStops =
            arrayOf(
                0.0f to MaterialTheme.colorScheme.onBackground,
                0.8f to MaterialTheme.colorScheme.background,
            ),
        )
    Box(
        modifier = modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.welcomescreen_background_blurred),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
        )
        Canvas(
            modifier = Modifier.fillMaxSize(),
        ) {
            drawRect(
                brush = brush,
            )
        }
    }
}

@Composable
private fun WelcomeScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(
                horizontal = dimensionResource(R.dimen.welcome_screen_content_horizontal_padding),
                vertical = dimensionResource(R.dimen.welcome_screen_content_vertical_padding),
            ),
    ) {
        val annotatedString =
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.typography.bodyLarge.color,
                        fontSize = 30.sp,
                    ),
                ) {
                    append(stringResource(R.string.welcome_screen_text_part1))
                }
                withStyle(
                    SpanStyle(
                        color = MaterialTheme.typography.bodyLarge.color,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                    ),
                ) {
                    append(stringResource(R.string.welcome_screen_text_part2))
                }
            }
        val buttonHorizontalGradientBrush =
            Brush.horizontalGradient(
                colors = listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.tertiary),
            )
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(dimensionResource(R.dimen.welcome_screen_content_image_width))
                .height(dimensionResource(R.dimen.welcome_screen_content_image_height)),
        )
        Spacer(
            modifier = Modifier.height(dimensionResource(R.dimen.welcome_screen_content_spacer_height)),
        )
        Text(
            text = annotatedString,
            lineHeight = 36.sp,
        )
        Spacer(
            modifier = Modifier.height(dimensionResource(R.dimen.welcome_screen_content_spacer_height)),
        )
        Text(
            text = stringResource(R.string.welcome_screen_description),
            color = MaterialTheme.typography.bodyLarge.color,
            style = MaterialTheme.typography.bodySmall,
        )
        Spacer(
            modifier = Modifier.height(dimensionResource(R.dimen.welcome_screen_content_spacer_height)),
        )
        Button(
            onClick = {},
            modifier =
            Modifier.fillMaxWidth()
                .height(dimensionResource(R.dimen.welcome_screen_content_button_height))
                .background(
                    brush = buttonHorizontalGradientBrush,
                    shape = RoundedCornerShape(size = dimensionResource(R.dimen.welcome_screen_content_button_background_shape_size)),
                ),
            colors =
            ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
            ),
        ) {
            Text(
                text = stringResource(R.string.welcome_screen_button_text),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    TMDBPracticeTheme {
        WelcomeScreen()
    }
}
