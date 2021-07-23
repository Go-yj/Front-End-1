package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_button.setOnClickListener {
            val intent = Intent(this, Registration1::class.java)
            startActivity(intent)
        }

        account_check_button.setOnClickListener {
            Toast.makeText(this, "계좌 인증 버튼 클릭", Toast.LENGTH_SHORT).show()
       }
    }
}