package hr.dice.filipbionda.tmdbpractice.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import hr.dice.filipbionda.tmdbpractice.R

val interFont = GoogleFont("Inter")
val provider =
    GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs,
    )

val InterFontFamily =
    FontFamily(
        Font(googleFont = interFont, fontProvider = provider, weight = FontWeight.Normal),
        Font(googleFont = interFont, fontProvider = provider, weight = FontWeight.Bold),
        Font(googleFont = interFont, fontProvider = provider, weight = FontWeight.Light),
        Font(googleFont = interFont, fontProvider = provider, weight = FontWeight.Medium),
        Font(googleFont = interFont, fontProvider = provider, weight = FontWeight.SemiBold),
        Font(googleFont = interFont, fontProvider = provider, weight = FontWeight.ExtraBold),
    )

val Typography =
    Typography(
        bodyLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 30.sp,
            lineHeight = 34.sp,
            letterSpacing = 0.5.sp,
            color = white,
        ),
        titleLarge =
            TextStyle(
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Bold,
                color = welcomeScreenPrimaryTextColor,
                fontSize = 22.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp,
            ),
        labelSmall =
            TextStyle(
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Bold,
                color = welcomeScreenPrimaryTextColor,
                fontSize = 14.sp,
                letterSpacing = 0.5.sp,
            ),
        bodySmall =
        TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = white,
        ),
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = white,
        ),
    )
