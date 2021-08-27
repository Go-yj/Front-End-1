package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.registration1.*

class Registration1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration1)

        check_circle_button.setOnClickListener {
            val intent = Intent(this, AccountList::class.java)
            startActivity(intent)
        }
    }
}