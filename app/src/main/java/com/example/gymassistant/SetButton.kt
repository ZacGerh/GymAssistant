package com.example.gymassistant

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.Toast

class SetButton (context: Context, attrs: AttributeSet) : androidx.appcompat.widget.AppCompatButton (context, attrs){

    private var maxNum = 12
    private var currentNum = 0
    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.SetButton,0,0).apply {
            try {
                maxNum = getInteger(R.styleable.SetButton_maxNum, 12)
                text = currentNum.toString()
            } finally {
                recycle()
            }
        }
        this.setOnClickListener{
            currentNum--
            if (currentNum < 0){
                currentNum = maxNum
            }
            text = currentNum.toString()
        }

    }


}