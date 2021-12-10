package com.example.gymassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.json.JSONObject
import java.lang.Exception
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val saveJson = SaveJsonObject()

        val benchText : EditText = findViewById(R.id.InclineBench)
        val ohp_Text : EditText = findViewById(R.id.OHP)
        val lateralRaisesText : EditText = findViewById(R.id.LateralRaises)
        val skullCrushersText : EditText = findViewById(R.id.SkullCrushers)
        val chinUpText : EditText = findViewById(R.id.ChinUps)
        val squatText : EditText = findViewById(R.id.Squat)
        val bentFliesText : EditText = findViewById(R.id.BentFlies)
        val bicepCurlText : EditText = findViewById(R.id.BicepCurls)


        val storage = PrivateStorage(this)
        //storage.writeWorkoutData("100")

        val toSet = storage.readWorkoutData()
        var json : JSONObject
        try {
            json = JSONObject(toSet)
        }
        catch (ex : Exception) {
            json = JSONObject()
            json.put("InclineBench", "1")
            json.put("OHP", "2")
            json.put("LateralRaises", "3")
            json.put("SkullCrushers", "4")

            json.put("ChinUps", "5")
            json.put("Squat", "6")
            json.put("BentFlies", "7")
            json.put("BicepCurls", "8")
        }

        benchText.setText(json.get("InclineBench") as String)
        ohp_Text.setText(json.get("OHP") as String)
        lateralRaisesText.setText(json.get("LateralRaises") as String)
        skullCrushersText.setText(json.get("SkullCrushers") as String)

        chinUpText.setText(json.get("ChinUps") as String)
        squatText.setText(json.get("Squat") as String)
        bentFliesText.setText(json.get("BentFlies") as String)
        bicepCurlText.setText(json.get("BicepCurls") as String)

        val saveButton : Button = findViewById(R.id.savebtn)

        saveButton.setOnClickListener {
            json.put("InclineBench", benchText.text.toString())
            json.put("OHP", ohp_Text.text.toString())
            json.put("LateralRaises", lateralRaisesText.text.toString())
            json.put("SkullCrushers", skullCrushersText.text.toString())

            json.put("ChinUps", chinUpText.text.toString())
            json.put("Squat", squatText.text.toString())
            json.put("BentFlies", bentFliesText.text.toString())
            json.put("BicepCurls", bicepCurlText.text.toString())



            storage.writeWorkoutData(json.toString())
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }


    }
}
