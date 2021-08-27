package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_button.setOnClickListener {
            Toast.makeText(this, "로그인 버튼 클릭", Toast.LENGTH_SHORT).show()
        }

        account_check_button.setOnClickListener {
            val intent = Intent(this, Registration1::class.java)
            startActivity(intent)
       }
    }
}