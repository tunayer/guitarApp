package com.tuna.musicappproject

import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

fun getScaleImageUrl(scale: String, onUrlReady: (String?) -> Unit) {
    val normalized = normalizeScale(scale)
    val storageRef = Firebase.storage.reference
    val imageRef = storageRef.child("scales/${normalized}.png")

    imageRef.downloadUrl
        .addOnSuccessListener { url ->
            onUrlReady(url.toString())
        }
        .addOnFailureListener {
            onUrlReady(null)
        }
}

fun normalizeScale(scale: String): String {
    return scale
        .replace("#", "sharp")
        .replace(" ", "")
        .replace("I", "i")
        .replace("/", "")
        .lowercase()
}

