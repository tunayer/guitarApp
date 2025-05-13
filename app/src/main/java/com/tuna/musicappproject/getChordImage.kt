package com.tuna.musicappproject

import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

fun getChordImageUrl(chord: String, onUrlReady: (String?) -> Unit) {
    val normalized = normalizeChord(chord)
    val storageRef = Firebase.storage.reference
    val imageRef = storageRef.child("chords/${normalized}.png")

    imageRef.downloadUrl
        .addOnSuccessListener { url ->
            onUrlReady(url.toString())
        }
        .addOnFailureListener {
            onUrlReady(null)
        }
}

fun normalizeChord(chord: String): String {
    return chord
        .replace("⁷", "7")
        .replace("⁵", "5")
        .replace("₂", "2")
        .replace("⁹", "9")
        .replace("¹¹", "11")
        .replace("¹³", "13")
        .replace("ᵇ", "b")
        .replace("⁽", "")
        .replace("⁾", "")
        .replace("ᵐ", "m")
        .replace("ᵃ", "a")
        .replace("ᵈ", "d")
        .replace("ʲ", "j")
        .replace("⁶", "6")
        .replace("⁄", "")
        .replace("#", "sharp")
        .replace("(", "")
        .replace(")", "")
        .replace(" ", "")
        .lowercase()
}

