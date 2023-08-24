package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.sdukdy.databinding.ActivityAddBinding
import com.example.sdukdy.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
    private lateinit var binding:ActivityChatBinding
    private lateinit var drawerLayout: DrawerLayout //드로어 메뉴

    private lateinit var receiverName : String //대화하는 상대방의 이름
    private lateinit var receiverUid : String // 대화하는 상대방의 id

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //넘어온 데이터 변수에 담기
        receiverName = intent.getStringExtra("name").toString()
        receiverUid = intent.getStringExtra("uID").toString()

        //액션바에 상대방 이름 보여주기기
        supportActionBar?.title = receiverName

        //드로어 메뉴 열기
        drawerLayout = findViewById(R.id.drawer)
        findViewById<View>(R.id.o_chat_menuBtn).setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }


        //최적의 스터디 시간 페이지 이동
        findViewById<View>(R.id.o_drawable_studytimeBtn).setOnClickListener {
            val intent= Intent(this@ChatActivity, StudytimeActivity::class.java)
            startActivity(intent)
        }

        //채팅방 수정하기 페이지 이동
        findViewById<View>(R.id.o_drawable_modifyBtn).setOnClickListener {
            val intent= Intent(this@ChatActivity, Add2Activity::class.java)
            startActivity(intent)
        }

        //퀴즈이동
        findViewById<View>(R.id.o_drawable_quizBtn).setOnClickListener {
            val intent= Intent(this@ChatActivity, QuizmainActivity::class.java)
            startActivity(intent)
        }

        binding.sendBtn.setOnClickListener {
            // send_message_text의 가시성을 변경합니다.
            if (binding.sendMessageText.visibility == View.INVISIBLE) {
                binding.sendMessageText.visibility = View.VISIBLE
            } else {
                binding.sendMessageText.visibility = View.INVISIBLE
            }
        }



    }


}