package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputBinding
import android.widget.EditText
import android.widget.Toast
import com.example.sdukdy.databinding.ActivityRecruitBinding

class RecruitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecruitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecruitBinding.inflate(layoutInflater)
        setContentView(binding.root) //여기까지는 뷰 설정

        //HomeAcitivy로 이동
        binding.back.setOnClickListener{
            //HomeAcitivy로 이동
            val intent = Intent(this@RecruitActivity, HomeActivity::class.java)
            startActivity(intent)
        }
        binding.rectangle18.setOnClickListener {
            // 모집글 2로 이동
            val intent = Intent(this@RecruitActivity, RecruitActivity2::class.java)
            startActivity(intent)
        }

        binding.hSearchclick.setOnClickListener{
            val searchText = binding.searchEditText.text.toString()
            if (searchText.isNotEmpty()) {
                when(searchText) {
                    "자료구조론" -> {
                        // 자료구조론에 대한 처리 로직 구현
                        navigateToSearchResult(searchText)
                    }
                    "인터넷프로그래밍" -> {
                        // 인터넷프로그래밍에 대한 처리 로직 구현

                    }

                }
            } else {
                showWarningMessage("검색어를 입력하세요.")
            }
        }


        // 채팅창 구현에 대한 코드
        val chatRoomName = intent.getStringExtra("chatRoomName")
        binding.chatRoomNameTextView.text=chatRoomName
        // 모집인원 구현에 대한 코드
        val peoplec = intent.getStringExtra("peoplec")
        // binding.hOnline2.text=peoplec
        if (peoplec != null) {
            binding.hOnline2.text = peoplec
        }


    }
    private fun navigateToSearchResult(searchText: String) {
        val intent = Intent(this,RecruitActivity2::class.java)
        intent.putExtra("searchText",searchText)
        startActivity(intent)
    }
    // 잘못되었을 때 사용자에게 경고문을 날리는 코드
    private fun showWarningMessage(message: String) {
        // 경고 메시지를 사용자에게 보여주는 로직 구현
        // 예: AlertDialog 또는 Toast를 사용하여 메시지 표시
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}