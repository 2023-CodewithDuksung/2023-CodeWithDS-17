package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        findViewById<View>(R.id.o_settings_backBtn).setOnClickListener {
            //MypageAcitivy로 이동 (백버튼)
            val intent = Intent(this@SettingsActivity, MypageActivity::class.java)
            startActivity(intent)
        }

        //하단바 동작

        findViewById<View>(R.id.o_settings_homeicon).setOnClickListener {
            //HomeAcitivy로 이동
            val intent = Intent(this@SettingsActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.o_settings_calendar).setOnClickListener {
            //TimeTableAcitivy로 이동
            val intent = Intent(this@SettingsActivity, TimeTableActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.o_settings_chatting).setOnClickListener {
            //ChattingAcitivy로 이동
            val intent = Intent(this@SettingsActivity, ChattingActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.o_settings_mypage).setOnClickListener {
            //MypageAcitivy로 이동
            val intent = Intent(this@SettingsActivity, MypageActivity::class.java)
            startActivity(intent)
        }
    }

}