package com.example.gymassistant

import android.content.Context
import android.util.AttributeSet

class Exercise (context: Context, attrs: AttributeSet) {
    // TODO: need to add this file as a custom view from Exercize.kt as an example.

    private var exerciseName = "exercise"
    private var weight = 0
    private var set1Num = 5
    private var set2Num = 6
    private var set3Num = 8

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.Exercise, 0, 0).apply {
            try {

                //TODO: get this exerciseName into a label
                exerciseName = getString(R.styleable.Exercise_exerciseName).toString()

                //TODO: get this weight into the editText
                weight = getInteger(R.styleable.Exercise_weight, 0)

                //TODO: get these set numbers into the setNum buttons
                set1Num = getInteger(R.styleable.Exercise_set1Num, 0)
                val set1Button = SetButton(context, set1Num)

                set2Num = getInteger(R.styleable.Exercise_set2Num, 0)
                val set2Button = SetButton(context, set2Num)

                set3Num = getInteger(R.styleable.Exercise_set3Num, 0)
                val set3Button = SetButton(context, set3Num)
            } finally {
                recycle()
            }
        }
    }
}