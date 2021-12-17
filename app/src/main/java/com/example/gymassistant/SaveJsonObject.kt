package com.example.gymassistant

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import org.json.JSONObject

class SaveJsonObject () : JSONObject (){

    init {
        this.put("InclineBench", "1")
        this.put("OHP", "2")
        this.put("LateralRaises", "3")
        this.put("SkullCrushers", "4")

        this.put("ChinUps", "5")
        this.put("Squat", "6")
        this.put("BentFlies", "7")
        this.put("BicepCurls", "8")
    }


}