package com.example.gymassistant

import android.content.Context
import java.io.File
import java.io.FileInputStream
import java.lang.Exception

class PrivateStorage (context: Context) {
    val path = context.getFilesDir()
    val workoutDir = File(path, "workout")
    val file = File(workoutDir, "Records.txt")

    fun writeWorkoutData(fileContents : String){
        workoutDir.mkdirs()
        file.writeText(fileContents)
    }
    fun readWorkoutData(): String {
        try {
            return FileInputStream(file).bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            workoutDir.mkdirs()
            file.writeText("")
            return ""
        }
    }
}
