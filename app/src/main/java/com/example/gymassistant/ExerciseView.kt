package com.example.gymassistant

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView

class ExerciseView(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {

    init {
        inflate(context, R.layout.exercise_view, this)

        val exerciseView = LinearLayout(context)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.ExerciseView)
        val textView: TextView = findViewById(R.id.exercise_name)
        textView.text = attributes.getString(R.styleable.ExerciseView_exercise_name)

        val buttonVal: Int = attributes.getInteger(R.styleable.ExerciseView_exercise_set, 0)
        val setView = SetButton(context, attrs, buttonVal)

        println(textView.parent.toString())
        //exerciseView.addView(textView)
        exerciseView.addView(setView)

        attributes.recycle()
    }



}