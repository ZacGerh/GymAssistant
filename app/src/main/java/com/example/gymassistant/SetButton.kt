package com.example.gymassistant

import android.content.Context
import android.util.AttributeSet

class SetButton (context: Context, attrs: AttributeSet, maxNum: Int ) : androidx.appcompat.widget.AppCompatButton (context, attrs){

    private var currentNum = 0
    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.SetButton,0,0).apply {
            try {

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