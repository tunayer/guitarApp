package com.tuna.musicappproject

val degrees = listOf("1", "b2", "2", "b3", "3", "4", "b5", "5", "b6", "6", "b7", "7")

val scaleDegrees: Map<String, Map<String, String>> = mapOf(
    "A" to mapOf(
        "1" to "A", "b2" to "Bb", "2" to "B", "b3" to "C", "3" to "C#",
        "4" to "D", "b5" to "Eb", "5" to "E", "b6" to "F", "6" to "F#",
        "b7" to "G", "7" to "G#"
    ),
    "B" to mapOf(
        "1" to "B", "b2" to "C", "2" to "C#", "b3" to "D", "3" to "D#",
        "4" to "E", "b5" to "F", "5" to "F#", "b6" to "G", "6" to "G#",
        "b7" to "A", "7" to "A#"
    ),
    "C" to mapOf(
        "1" to "C", "b2" to "Db", "2" to "D", "b3" to "Eb", "3" to "E",
        "4" to "F", "b5" to "Gb", "5" to "G", "b6" to "Ab", "6" to "A",
        "b7" to "Bb", "7" to "B"
    ),
    "D" to mapOf(
        "1" to "D", "b2" to "Eb", "2" to "E", "b3" to "F", "3" to "F#",
        "4" to "G", "b5" to "Ab", "5" to "A", "b6" to "Bb", "6" to "B",
        "b7" to "C", "7" to "C#"
    ),
    "E" to mapOf(
        "1" to "E", "b2" to "F", "2" to "F#", "b3" to "G", "3" to "G#",
        "4" to "A", "b5" to "Bb", "5" to "B", "b6" to "C", "6" to "C#",
        "b7" to "D", "7" to "D#"
    ),
    "F" to mapOf(
        "1" to "F", "b2" to "Gb", "2" to "G", "b3" to "Ab", "3" to "A",
        "4" to "Bb", "b5" to "Cb", "5" to "C", "b6" to "Db", "6" to "D",
        "b7" to "Eb", "7" to "E"
    ),
    "G" to mapOf(
        "1" to "G", "b2" to "Ab", "2" to "A", "b3" to "Bb", "3" to "B",
        "4" to "C", "b5" to "Db", "5" to "D", "b6" to "Eb", "6" to "E",
        "b7" to "F", "7" to "F#"
    ),
    "Bb" to mapOf(
        "1" to "Bb", "b2" to "Cb", "2" to "C", "b3" to "Db", "3" to "D",
        "4" to "Eb", "b5" to "Fb", "5" to "F", "b6" to "Gb", "6" to "G",
        "b7" to "Ab", "7" to "A"
    ),
    "C#" to mapOf(
        "1" to "C#", "b2" to "D", "2" to "D#", "b3" to "E", "3" to "E#",
        "4" to "F#", "b5" to "G", "5" to "G#", "b6" to "A", "6" to "A#",
        "b7" to "B", "7" to "B#"
    ),
    "D#" to mapOf(
        "1" to "D#", "b2" to "E", "2" to "E#", "b3" to "F#", "3" to "F##",
        "4" to "G#", "b5" to "A", "5" to "A#", "b6" to "B", "6" to "B#",
        "b7" to "C#", "7" to "C##"
    ),
    "F#" to mapOf(
        "1" to "F#", "b2" to "G", "2" to "G#", "b3" to "A", "3" to "A#",
        "4" to "B", "b5" to "C", "5" to "C#", "b6" to "D", "6" to "D#",
        "b7" to "E", "7" to "F"
    ),
    "G#" to mapOf(
        "1" to "G#", "b2" to "A", "2" to "A#", "b3" to "B", "3" to "B#",
        "4" to "C#", "b5" to "D", "5" to "D#", "b6" to "E", "6" to "F",
        "b7" to "F#", "7" to "G"
    ),
    "Db" to mapOf(
        "1" to "Db", "b2" to "Ebb", "2" to "Eb", "b3" to "Fb", "3" to "F",
        "4" to "Gb", "b5" to "Abb", "5" to "Ab", "b6" to "Bbb", "6" to "Bb",
        "b7" to "Cb", "7" to "C"
    ),
    "A#" to mapOf(
        "1" to "A#", "b2" to "B", "2" to "B#", "b3" to "C#", "3" to "C##",
        "4" to "D#", "b5" to "E", "5" to "E#", "b6" to "F#", "6" to "F##",
        "b7" to "G#", "7" to "G##"
    ),
    "Eb" to mapOf(
        "1" to "Eb", "b2" to "Fb", "2" to "F", "b3" to "Gb", "3" to "G",
        "4" to "Ab", "b5" to "Bbb", "5" to "Bb", "b6" to "Cb", "6" to "C",
        "b7" to "Db", "7" to "D"
    ),
    "Gb" to mapOf(
        "1" to "Gb", "b2" to "Abb", "2" to "Ab", "b3" to "Bbb", "3" to "Bb",
        "4" to "Cb", "b5" to "Dbb", "5" to "Db", "b6" to "Ebb", "6" to "Eb",
        "b7" to "Fb", "7" to "F"
    ),
    "Ab" to mapOf(
        "1" to "Ab", "b2" to "Bbb", "2" to "Bb", "b3" to "Cb", "3" to "C",
        "4" to "Db", "b5" to "Ebb", "5" to "Eb", "b6" to "Fb", "6" to "F",
        "b7" to "Gb", "7" to "G"
    )
)

val scales = scaleDegrees.keys.toList()