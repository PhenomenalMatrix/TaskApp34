package com.orozbek.taskApp.presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.orozbek.taskApp.R

class MainActivity2 : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        editText = findViewById(R.id.nameEt)
        button = findViewById(R.id.saveDataBtn)

        button.setOnClickListener {
            initListeners()
        }

    }

    private fun initListeners() {
        var txt = editText.text.toString()
        var intent = Intent()
        intent.putExtra("key", txt)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}