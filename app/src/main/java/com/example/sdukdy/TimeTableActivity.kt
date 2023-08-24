package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class TimeTableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_table)

        findViewById<View>(R.id.o_timetable_addBtn).setOnClickListener {
            //SubjectAcitivy로 이동 (과목 추가하기 버튼)
            val intent = Intent(this@TimeTableActivity, SubjectActivity::class.java)
            startActivity(intent)
        }

        //하단바 동작
        findViewById<View>(R.id.o_timetable_homeicon).setOnClickListener {
            //HomeAcitivy로 이동
            val intent = Intent(this@TimeTableActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.o_timetable_chatting).setOnClickListener {
            //ChattingAcitivy로 이동
            val intent = Intent(this@TimeTableActivity, ChattingActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.o_timetable_mypage).setOnClickListener {
            //MypageAcitivy로 이동
            val intent = Intent(this@TimeTableActivity, MypageActivity::class.java)
            startActivity(intent)
        }

        val targetCell: TextView = findViewById(R.id.monday09)

        // MainActivity에서 전달된 색상을 가져와 설정
        val color = intent.getIntExtra("color", 0)
        if (color != 0) {
            targetCell.setBackgroundColor(color)
        }

    }
}