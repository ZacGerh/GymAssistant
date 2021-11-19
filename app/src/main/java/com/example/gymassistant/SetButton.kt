package com.example.gymassistant

import android.content.Context

class SetButton (context: Context, maxNumber: Int) : androidx.appcompat.widget.AppCompatButton(context){

    private var maxNum = 12
    private var currentNum = 0

    init {
        maxNum = maxNumber
        text = currentNum.toString()

        this.setOnClickListener{
            currentNum--
            if (currentNum < 0){
                currentNum = maxNum
            }
            text = currentNum.toString()
        }
    }
}