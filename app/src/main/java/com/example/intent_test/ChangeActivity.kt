package com.example.intent_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_change2.*

class ChangeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change2)

       val intentNumber = intent.getStringExtra("old")
       numChange.setText("${intentNumber}")

        changeOk.setOnClickListener {

            val inputNewNumber =numChange.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("number",inputNewNumber)
            setResult(RESULT_OK,resultIntent)
            finish()


        }
    }
}