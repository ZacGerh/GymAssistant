package com.example.gymassistant

import android.content.Context
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class PrivateStorage (private val context: Context) {
    val path = context.getFilesDir()
    val workoutDir = File(path, "workout")
    val file = File(workoutDir, "Records.txt")

    fun writeWorkoutData(fileContents : String){
        workoutDir.mkdirs()
        file.writeText(fileContents)
    }
    fun readWorkoutData(): String {
        val inputAsString = FileInputStream(file).bufferedReader().use { it.readText() }
        return inputAsString;
    }
}
