package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MypageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        findViewById<View>(R.id.o_mypage_profileChangeBtn).setOnClickListener {
            //ProfileAcitivy로 이동 (회원정보 수정 화살표 버튼)
            val intent = Intent(this@MypageActivity, ProfileActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.o_mypage_settingsBtn).setOnClickListener {
            //SettingsAcitivy로 이동 (설정 화살표 버튼)
            val intent = Intent(this@MypageActivity, SettingsActivity::class.java)
            startActivity(intent)
        }

        // 하단바 아이콘 버튼들
        findViewById<View>(R.id.o_mypage_homeicon).setOnClickListener {
            //HomeAcitivy로 이동
            val intent = Intent(this@MypageActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.o_mypage_calendar).setOnClickListener {
            //TimeTableAcitivy로 이동
            val intent = Intent(this@MypageActivity, TimeTableActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.o_mypage_chatting).setOnClickListener {
            //ChattingAcitivy로 이동
            val intent = Intent(this@MypageActivity, ChattingActivity::class.java)
            startActivity(intent)
        }


    }
}