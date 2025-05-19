package com.tuna.musicappproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NoteDegreeGameUI() {
    var scale by remember { mutableStateOf("") }
    var degree by remember { mutableStateOf("") }
    var answer by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(fontFamily = FontFamily.Monospace,
            text = "RANDOM DEGREE OF A NOTE",
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            ),
            modifier = Modifier.padding(top = 30.dp)
        )

        Spacer(modifier = Modifier.padding(40.dp))

        Text(fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            text = "Try to guess the scale degree of the given note!",
            )

        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = {
            scale = scales.random()
            degree = degrees.random()
            answer = ""
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFfcd560),
                contentColor = Color.White
            ),

            modifier = Modifier.background(
                Color(0xFFfcd560),
                shape = RoundedCornerShape(12.dp)
            )
        )
        {
            Text("GET A RANDOM NOTE", fontFamily = FontFamily.Monospace)
        }

        Spacer(modifier = Modifier.padding(5.dp))

        OutlinedTextField(
            value = scale,
            onValueChange = {},
            label = { Text("Note", fontFamily = FontFamily.Monospace) },
            enabled = false
        )

        Spacer(modifier = Modifier.padding(5.dp))

        OutlinedTextField(
            value = degree,
            onValueChange = {},
            label = { Text("Degree", fontFamily = FontFamily.Monospace) },
            enabled = false
        )

        Spacer(modifier = Modifier.padding(5.dp))

        Button(onClick = {
            answer = scaleDegrees[scale]?.get(degree) ?: ""
        },

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFfcd560),
                contentColor = Color.White
            ),

            modifier = Modifier.background(
                Color(0xFFfcd560),
                shape = RoundedCornerShape(12.dp)
            ),
        ) {
            Text("SEE THE ANSWER!", fontFamily = FontFamily.Monospace)
        }

        OutlinedTextField(
            value = answer,
            onValueChange = {},
            label = { Text("Show", fontFamily = FontFamily.Monospace) },
            enabled = false
        )
    }
}

