package com.example.gymassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val storage = PrivateStorage(this)
        //storage.writeWorkoutData("100")
        val benchtext : EditText = findViewById(R.id.benchLbs)
        val toSet = storage.readWorkoutData()

        benchtext.setText(toSet, TextView.BufferType.EDITABLE);

        val saveButton : Button = findViewById(R.id.savebtn)

        saveButton.setOnClickListener {
            storage.writeWorkoutData(benchtext.text.toString())

            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }


    }
}
