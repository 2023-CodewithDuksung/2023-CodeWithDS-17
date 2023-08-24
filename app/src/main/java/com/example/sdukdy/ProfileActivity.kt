package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        findViewById<View>(R.id.o_profile_BackBtn).setOnClickListener {
            //MypageAcitivy로 이동 (백버튼)
            val intent = Intent(this@ProfileActivity, MypageActivity::class.java)
            startActivity(intent)
        }


        //하단바 동작

        findViewById<View>(R.id.o_profile_homeicon).setOnClickListener {
            //HomeAcitivy로 이동
            val intent = Intent(this@ProfileActivity, HomeActivity::class.java)
            startActivity(intent)
        }
        findViewById<View>(R.id.o_profile_calendar).setOnClickListener {
            //TimeTableAcitivy로 이동
            val intent = Intent(this@ProfileActivity, TimeTableActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.o_profile_chatting).setOnClickListener {
            //ChattingAcitivy로 이동
            val intent = Intent(this@ProfileActivity, ChattingActivity::class.java)
            startActivity(intent)
        }
        findViewById<View>(R.id.o_profile_mypage).setOnClickListener {
            //MypageAcitivy로 이동
            val intent = Intent(this@ProfileActivity, MypageActivity::class.java)
            startActivity(intent)
        }
    }
}