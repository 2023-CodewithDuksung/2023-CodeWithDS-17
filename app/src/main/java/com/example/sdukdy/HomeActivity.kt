package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
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
        // 자료구조론 바로가기 눌렀을 때 신청화면으로 이동
        findViewById<View>(R.id.h_rectangle25).setOnClickListener {
            val intent= Intent(this@HomeActivity, RecruitActivity2::class.java)
            startActivity(intent)
        }
        // 검색창 기능
        val searchEditText = findViewById<EditText>(R.id.searchEditText2)
        searchEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearch(searchEditText.text.toString())
                return@setOnEditorActionListener true
            }
            false
        }
        // 새 채팅방 생성하기를 눌렀을 때 생성 창으로 이동 h_rectangle6
        findViewById<View>(R.id.h_rectangle6).setOnClickListener {
            val intent= Intent(this@HomeActivity, AddActivity::class.java)
            startActivity(intent)
        }
    }
    private fun performSearch(query: String) {
        // 검색 로직을 구현하고 검색어(query)를 이용하여 검색 결과를 처리
        // 검색 결과 표시 등의 작업을 수행
    }
    // < 버튼 눌렀을 때 다시 홈 화면으로 돌아갈 수 있도록 이벤트 처리
}