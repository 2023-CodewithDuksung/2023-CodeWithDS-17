package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText

class RecruitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recruit)

        findViewById<View>(R.id.back).setOnClickListener {
            //HomeAcitivy로 이동
            val intent = Intent(this@RecruitActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        val searchEditText = findViewById<EditText>(R.id.searchEditText)
        searchEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearch(searchEditText.text.toString())
                return@setOnEditorActionListener true
            }
            false
        }

    }
    private fun performSearch(query: String) {
        // 검색 로직을 구현하고 검색어(query)를 이용하여 검색 결과를 처리
        // 검색 결과 표시 등의 작업을 수행
    }
    // < 버튼 눌렀을 때 다시 홈 화면으로 돌아갈 수 있도록 이벤트 처리



}