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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hr.dice.filipbionda.tmdbpractice.R
import hr.dice.filipbionda.tmdbpractice.ui.theme.buttonFirstColor
import hr.dice.filipbionda.tmdbpractice.ui.theme.buttonSecondColor
import hr.dice.filipbionda.tmdbpractice.ui.theme.overlayGradientFirstColor
import hr.dice.filipbionda.tmdbpractice.ui.theme.overlayGradientSecondColor
import hr.dice.filipbionda.tmdbpractice.ui.theme.welcomeScreenPrimaryTextColor

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier){
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        val brush = Brush.verticalGradient(
            colorStops = arrayOf(
                0.0f to overlayGradientFirstColor,
                0.8f to overlayGradientSecondColor
            ),
        )
        Image(
            painter = painterResource(R.drawable.welcomescreen_background_blurred),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Canvas(
                modifier = Modifier.fillMaxSize()
            ) {
                drawRect(
                    brush = brush,
                )
            }
        Column(
            modifier = Modifier.align(alignment = Alignment.BottomCenter)
                .padding(horizontal = 28.dp, vertical = 42.dp)
        ) {
            val annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(color = welcomeScreenPrimaryTextColor)
                ){
                    append(stringResource(R.string.welcome_screen_text_part1))
                }
                withStyle(
                    style = SpanStyle(color = welcomeScreenPrimaryTextColor, fontWeight = FontWeight.Bold
                    )
                ){
                    append(stringResource(R.string.welcome_screen_text_part2))
                }
            }
            val buttonHorizontalGradientBrush = Brush.horizontalGradient(
                colors = listOf(buttonFirstColor, buttonSecondColor)
            )
           Image(
               painter = painterResource(R.drawable.img),
               contentDescription = null,
               contentScale = ContentScale.FillBounds,
               modifier = Modifier
                   .width(176.dp)
                   .height(18.dp)
           )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Text(
                text = annotatedString,
                color = welcomeScreenPrimaryTextColor,
                fontSize = 30.sp,
                lineHeight = 36.sp
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Text(
                text = stringResource(R.string.welcome_screen_description),
                color = welcomeScreenPrimaryTextColor,
                fontSize = 16.sp
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
                    .height(48.dp)
                    .background(
                        brush = buttonHorizontalGradientBrush,
                        shape = RoundedCornerShape(size = 20.dp)
                        ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Text(
                    text = stringResource(R.string.welcome_screen_button_text),
                    fontSize = 20.sp,
                    color = welcomeScreenPrimaryTextColor,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen()
}

