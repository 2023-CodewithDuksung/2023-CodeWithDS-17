package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.sdukdy.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<View>(R.id.h_chatting).setOnClickListener {
            //ChattingAcitivy로 이동
            val intent = Intent(this@HomeActivity, ChattingActivity::class.java)
            startActivity(intent)
        }
        // fullView를 눌렀을 때 모집 글로 이동
        findViewById<View>(R.id.fullView).setOnClickListener {

            val intent = Intent(this@HomeActivity, RecruitActivity::class.java)
            startActivity(intent)
        }
        // h_timetable을 눌렀을 때 시간표로 이동
        findViewById<View>(R.id.h_timetable).setOnClickListener {
            val intent= Intent(this@HomeActivity, TimeTableActivity::class.java)
            startActivity(intent)
        }
        // user_02를 눌렀을 때 시간표로 이동
        findViewById<View>(R.id.user_02).setOnClickListener {
            val intent= Intent(this@HomeActivity, MypageActivity::class.java)
            startActivity(intent)
        }
    }
}