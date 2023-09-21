package com.example.nestedlayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollBtn = findViewById<Button>(R.id.roll_btn)
        val layouts = arrayOf(
            findViewById<LinearLayout>(R.id.first_layout),
            findViewById<LinearLayout>(R.id.second_layout),
            findViewById<ConstraintLayout>(R.id.third_layout)
        )

        rollBtn.setOnClickListener {
            currentIndex += 1
            for (layout in layouts) {
                clearAndUpdateText(layout)
            }
        }
    }

    private fun clearAndUpdateText(layout: ViewGroup) {
        val textViewList = layout.getAllTextViews()
        for (i in 0 until textViewList.size) {
            val currentTextView = textViewList[i]
            if (currentTextView.text.toString() != "") {
                val nextIndex = (i + 1) % textViewList.size
                currentTextView.text = ""
                val nextTextView = textViewList[nextIndex]
                nextTextView.text = (currentIndex + 1).toString()
                return
            }
        }
    }

    fun ViewGroup.getAllTextViews(): List<TextView> {
        val textViewList = mutableListOf<TextView>()
        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            if (childView is TextView) {
                textViewList.add(childView)
            } else if (childView is ViewGroup) {
                textViewList.addAll(childView.getAllTextViews())
            }
        }
        return textViewList
    }
}
