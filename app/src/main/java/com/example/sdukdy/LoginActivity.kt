package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 회원가입 창으로 이동
        findViewById<View>(R.id.find).setOnClickListener {
            val intent = Intent(this@LoginActivity, SignupActivity::class.java)
            startActivity(intent)
        }




        // 여기다 코드 복사
        val chevron = findViewById<Button>(R.id.find)
        // 페이지 이동
        fun moveToAnotherPage(){
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        // 함수호출
        chevron.setOnClickListener{
            moveToAnotherPage()
        }




    }
}