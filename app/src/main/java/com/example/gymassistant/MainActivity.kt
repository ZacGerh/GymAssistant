package com.example.gymassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.gymassistant.databinding.ActivityMainBinding
import com.google.gson.Gson
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var saveData = SaveJsonObject()


    override fun onCreate(savedInstanceState: Bundle?) {
        // Necessary
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).apply {
            this.lifecycleOwner = this@MainActivity
            this.viewmodel = mainViewModel
        }
        // Necessary

        loadSavedData()
        mainViewModel.benchText.value = saveData.benchText
        mainViewModel.ohpText.value = saveData.ohpText
        mainViewModel.lateralRaisesText.value = saveData.lateralRaisesText
        mainViewModel.skullCrushersText.value = saveData.skullCrushersText
        mainViewModel.chinUpText.value = saveData.chinUpText
        mainViewModel.squatText.value = saveData.squatText
        mainViewModel.bentFliesText.value = saveData.bentFliesText
        mainViewModel.bicepCurlText.value = saveData.bicepCurlText
        mainViewModel.benchText.observe(this, {
            saveData.benchText = it
        })
        mainViewModel.ohpText.observe(this, {
            saveData.ohpText = it
        })
        mainViewModel.lateralRaisesText.observe(this, {
            saveData.lateralRaisesText = it
        })
        mainViewModel.skullCrushersText.observe(this, {
            saveData.skullCrushersText = it
        })
        mainViewModel.chinUpText.observe(this, {
            saveData.chinUpText = it
        })
        mainViewModel.squatText.observe(this, {
            saveData.squatText = it
        })
        mainViewModel.bentFliesText.observe(this, {
            saveData.bentFliesText = it
        })
        mainViewModel.bicepCurlText.observe(this, {
            saveData.bicepCurlText = it
        })

    }

    override fun onResume() {
        super.onResume()
        loadSavedData()
    }

    override fun onPause() {
        saveSavedData()
        super.onPause()
    }



    private fun loadSavedData(){

        try {
            saveData = Gson().fromJson(PrivateStorage(this.filesDir).readWorkoutData(), SaveJsonObject::class.java)
        }
        catch (ex : Exception) {
            //saveData = SaveJsonObject()
        }
    }

    private fun saveSavedData(){

        PrivateStorage(this.filesDir).writeWorkoutData(Gson().toJson(saveData))
    }



}
