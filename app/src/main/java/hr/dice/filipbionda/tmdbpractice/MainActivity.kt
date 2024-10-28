package hr.dice.filipbionda.tmdbpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import hr.dice.filipbionda.tmdbpractice.ui.theme.TMDBPracticeTheme
import hr.dice.filipbionda.tmdbpractice.ui.welcomescreen.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TMDBPracticeTheme {
                WelcomeScreen()
            }
        }
    }
}
