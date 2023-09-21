package com.example.complexevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val text = findViewById<TextView>(R.id.textView)
        val input = findViewById<EditText>(R.id.textInput)
        val progress = findViewById<ProgressBar>(R.id.progressBar)

        button.setOnClickListener() {
            if (!checkBox.isChecked) {
                return@setOnClickListener
            }

            if (input.text.toString() == "") {
                return@setOnClickListener
            }

            text.text = input.text.toString()
            progress.progress += 10
        }
    }
}