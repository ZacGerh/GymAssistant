package com.example.gymassistant

import android.content.Context
import java.io.File
import java.io.FileInputStream

class PrivateStorage (path : File) {
    val workoutDir = File(path, "workout")
    val file = File(workoutDir, "Records.txt")

    fun writeWorkoutData(fileContents : String){
        workoutDir.mkdirs()
        file.writeText(fileContents)
    }
    fun readWorkoutData(): String {
        return FileInputStream(file).bufferedReader().use { it.readText() }
    }
}
