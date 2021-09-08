package com.example.intent_test

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_change.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_FOR_NUMBER = 1009
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        다이얼 예제
        callingBtn.setOnClickListener {

            val inputNumber = sendTxt.text.toString()

            val myUri = Uri.parse("tel:${inputNumber}")
            val myIntent = Intent(Intent.ACTION_DIAL,myUri)
            startActivity(myIntent)

        }
//전화번호 변경
        numberChange.setOnClickListener {


        val myIntent = Intent(this, ChangeActivity::class.java)

            val oldNumber =sendTxt.text.toString()
            myIntent.putExtra("old",oldNumber)
        startActivityForResult(myIntent,REQUEST_FOR_NUMBER)


        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==REQUEST_FOR_NUMBER){
            if(resultCode== RESULT_OK)
            {
                val newNumber = data?.getStringExtra("number")
                sendTxt.text=newNumber
            }
        }
    }
}