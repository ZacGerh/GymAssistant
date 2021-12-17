package com.example.gymassistant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.os.CountDownTimer
import android.widget.Toast

object RunningTimer{
    val start = 90_000L
    var timer = start
    lateinit var countDownTimer: CountDownTimer
    private val _currentRunTime = MutableLiveData<String>()
    val currentRunTime: LiveData<String>
        get() = _currentRunTime

    private fun setText(toSet: String) {
        _currentRunTime.value = toSet
    }

    init {
        setTextTimer()
    }
    fun setTextTimer() {
        val seconds = (timer / 1000) % 60
        val minutes = (timer / (1000 * 60) % 60)
        val ms = timer % 60

        val format = String.format("%02d:%02d:%02d", minutes, seconds, ms)
        setText(format)
    }

    fun startTimer() {
        countDownTimer = object : CountDownTimer(timer,50){
            //            end of timer
            override fun onFinish() {
                val format = String.format("%02d:%02d:%02d", 0,0,0)
                setText(format)
            }

            override fun onTick(millisUntilFinished: Long) {
                timer = millisUntilFinished
                setTextTimer()
            }

        }.start()
    }

    fun resetTimer() {
        countDownTimer.cancel()
        timer = start
        setTextTimer()
        startTimer()
    }

    var started = false
    fun onSelectSetButton() {
        if(started == false){
            started = true
            startTimer()
        }
        else{
            resetTimer()
        }
    }

}