package com.example.sdukdy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ChatActivity : AppCompatActivity() {

    private lateinit var receiverName : String //대화하는 상대방의 이름
    private lateinit var receiverUid : String // 대화하는 상대방의 id

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        //넘어온 데이터 변수에 담기
        receiverName = intent.getStringExtra("name").toString()
        receiverUid = intent.getStringExtra("uID").toString()

        //액션바에 상대방 이름 보여주기기
        supportActionBar?.title = receiverName

    }


}