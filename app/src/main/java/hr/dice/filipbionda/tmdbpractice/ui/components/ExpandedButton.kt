package hr.dice.filipbionda.tmdbpractice.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hr.dice.filipbionda.tmdbpractice.R
import hr.dice.filipbionda.tmdbpractice.ui.theme.TMDBPracticeTheme

@Composable
fun ExpandedButton(
    onClick: () -> Unit,
    content: @Composable ()->Unit,
    modifier: Modifier = Modifier,
    colors: List<Color> = listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.tertiary,
    )
){
    val buttonHorizontalGradientBrush =
        Brush.horizontalGradient(
            colors = colors,
        )

    Button(
        onClick = onClick,
        modifier =
        modifier
            .fillMaxWidth()
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
       content()
    }
}

@Preview
@Composable
fun ExpandedButtonPreview(){
    TMDBPracticeTheme {
        ExpandedButton(
            onClick = {},
            content = {
                Row {
                    Icon(
                        imageVector = Icons.Outlined.PlayCircle,
                        contentDescription = null
                    )
                    Spacer(
                        modifier = Modifier.width(10.dp)
                    )
                    Text(
                        text = "Play trailer"
                    )
                }
            }
        )
    }
}
