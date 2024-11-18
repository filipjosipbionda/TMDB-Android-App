package hr.dice.filipbionda.tmdbpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import hr.dice.filipbionda.tmdbpractice.ui.homescreen.HomeScreen
import hr.dice.filipbionda.tmdbpractice.ui.theme.TMDBPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TMDBPracticeTheme {
                HomeScreen(
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }
    }
}
