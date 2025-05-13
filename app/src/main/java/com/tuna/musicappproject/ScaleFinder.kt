package com.tuna.musicappproject

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.FirebaseStorage
import com.tuna.musicappproject.ui.theme.MusicAppProjectTheme

@Composable

fun ScaleFinderUI() {
    val notes = listOf(
        "A",
        "A#/Bb",
        "B",
        "C",
        "C#/Db",
        "D",
        "D#/Eb",
        "E",
        "F",
        "F#/Gb",
        "G",
        "G#/Ab",
    )
    var selectedNote by remember { mutableStateOf("C") }
    var selectedScale by remember { mutableStateOf("c ionian") }

    val displayedScales = scaleMap[selectedNote] ?: emptyList()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth().height(60.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(notes) { note ->
                Button(
                    onClick = { selectedNote = note },
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
                ) {
                    Text(text = note)
                }
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .height(200.dp)
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(displayedScales) { scale ->
                Button(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp),
                    onClick = {selectedScale = scale},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFfcd560)),
                    contentPadding = PaddingValues(horizontal = 2.dp, vertical = 0.dp)
                ) {
                    Text(
                        text = scale,
                        fontSize = 12.sp,
                        maxLines = 1,
                        softWrap = false
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        FirebaseScaleImage(selectedScale)

    }

    Spacer(modifier = Modifier.padding(5.dp))


}

@Composable
fun FirebaseScaleImage(scaleName: String) {
    val context = LocalContext.current
    var imageUrl by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(scaleName) {
        getScaleImageUrl(scaleName) { url ->
            imageUrl = url
        }
        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.reference
        val normalized = normalizeScale(scaleName)
        val imageRef = storageRef.child("scales/${normalized}.png")

        imageRef.downloadUrl.addOnSuccessListener { uri ->
            imageUrl = uri.toString()
        }.addOnFailureListener {
            imageUrl = null
        }
    }

    imageUrl?.let { url ->
        AsyncImage(
            model = url,
            contentDescription = scaleName,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Fit
        )
    }

}




@Preview(showBackground = true)
@Composable
fun ScaleGridPreviewScreen() {
    MusicAppProjectTheme {
        ScaleFinderUI()
    }
}



