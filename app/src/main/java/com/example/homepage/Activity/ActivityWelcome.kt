package com.example.homepage.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.homepage.R

class ActivityWelcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val btn : Button = findViewById(R.id.btn_wlcm)

        btn.setOnClickListener(View.OnClickListener {
//            Inten(application,MainActivity.class)
            val inten : Intent = Intent(this, MainActivity::class.java)
            startActivity(inten)
            finish()
        })
    }
}