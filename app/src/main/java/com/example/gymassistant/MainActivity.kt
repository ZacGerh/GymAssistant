package com.example.gymassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val storage = PrivateStorage(this)



        val benchText : EditText = findViewById(R.id.InclineBench)

        val ohpText : EditText = findViewById(R.id.OHP)
        val lateralRaisesText : EditText = findViewById(R.id.LateralRaises)
        val skullCrushersText : EditText = findViewById(R.id.SkullCrushers)
        val chinUpText : EditText = findViewById(R.id.ChinUps)
        val squatText : EditText = findViewById(R.id.Squat)
        val bentFliesText : EditText = findViewById(R.id.BentFlies)
        val bicepCurlText : EditText = findViewById(R.id.BicepCurls)

        var saveData = SaveJsonObject()
        try {
            saveData = Gson().fromJson<SaveJsonObject>(storage.readWorkoutData(), SaveJsonObject::class.java)
        }
        catch (ex : Exception) {
            //
        }


        benchText.setText(saveData.benchText)
        ohpText.setText(saveData.ohpText)
        lateralRaisesText.setText(saveData.lateralRaisesText)
        skullCrushersText.setText(saveData.skullCrushersText)

        chinUpText.setText(saveData.chinUpText)
        squatText.setText(saveData.squatText)
        bentFliesText.setText(saveData.bentFliesText)
        bicepCurlText.setText(saveData.bicepCurlText)

        val saveButton : Button = findViewById(R.id.savebtn)

        saveButton.setOnClickListener {
            saveData.benchText = benchText.text.toString()
            saveData.ohpText = ohpText.text.toString()
            saveData.lateralRaisesText = lateralRaisesText.text.toString()
            saveData.skullCrushersText = skullCrushersText.text.toString()
            saveData.chinUpText = chinUpText.text.toString()
            saveData.squatText = squatText.text.toString()
            saveData.bentFliesText = bentFliesText.text.toString()
            saveData.bicepCurlText = bicepCurlText.text.toString()
            storage.writeWorkoutData(Gson().toJson(saveData))
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }


    }
}
