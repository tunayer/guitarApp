package com.tuna.musicappproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tuna.musicappproject.ui.theme.MusicAppProjectTheme


enum class Screen {
    Home, NoteDegreeGame, ChordFinder, ScaleFinder
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicAppProjectTheme {
                var currentScreen by remember { mutableStateOf(Screen.Home) }

                when (currentScreen) {
                    Screen.Home -> MainScreen(
                        onNavigateToNoteGame = { currentScreen = Screen.NoteDegreeGame },
                        onNavigateToChordFinder = { currentScreen = Screen.ChordFinder },
                        onNavigateToScaleFinder = { currentScreen = Screen.ScaleFinder }
                    )

                    Screen.NoteDegreeGame -> NoteDegreeGameUI()
                    Screen.ChordFinder -> ChordFinderUI()
                    Screen.ScaleFinder -> ScaleFinderUI()
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    onNavigateToNoteGame: () -> Unit,
    onNavigateToChordFinder: () -> Unit,
    onNavigateToScaleFinder: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButtonWithLabel(
            iconContent = { Text("🎵", fontSize = 30.sp) },
            label = "NOTE GAME",
            onClick = onNavigateToNoteGame
        )

        Spacer(modifier = Modifier.height(32.dp))

        IconButtonWithLabel(
            iconContent = { Text("🎸", fontSize = 30.sp) },
            label = "CHORD FINDER",
            onClick = onNavigateToChordFinder
        )

        Spacer(modifier = Modifier.height(32.dp))

        IconButtonWithLabel(
            iconContent = { Text("\uD83C\uDFBC", fontSize = 30.sp) },
            label = "SCALE FINDER",
            onClick = onNavigateToScaleFinder
        )
    }
}

@Composable
fun IconButtonWithLabel(
    iconContent: @Composable () -> Unit,
    label: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFfcd560)),
        modifier = Modifier
            .size(140.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            iconContent()
            Spacer(modifier = Modifier.height(8.dp))
            Text(label, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MusicAppProjectTheme {
        MainScreen(
            onNavigateToNoteGame = {},
            onNavigateToChordFinder = {},
            onNavigateToScaleFinder = {},

            )
    }
}



