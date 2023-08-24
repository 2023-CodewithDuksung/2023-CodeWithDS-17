package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdukdy.databinding.ActivityChattingBinding

class ChattingActivity : AppCompatActivity() {
    private lateinit var binding:ActivityChattingBinding
    //var nameDatas:MutableList<String>?=null
    //var contentDatas:MutableList<String>?=null
    //lateinit var adapter:MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChattingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //하단바 동작
        binding.hHomeicon.setOnClickListener {
            //HomeAcitivy로 이동
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        // h_timetable을 눌렀을 때 시간표로 이동
        binding.hTimetable.setOnClickListener {
            val intent= Intent(this, TimeTableActivity::class.java)
            startActivity(intent)
        }
        // user_02를 눌렀을 때 시간표로 이동
        binding.user02.setOnClickListener {
            val intent= Intent(this, MypageActivity::class.java)
            startActivity(intent)
        }

        //채팅을 선택하면 채팅창으로 이동
        binding.chatBox.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }


        //채팅 리사이클러뷰
        //add................................


//        val layoutManager = LinearLayoutManager(this)
//        binding.mainRecyclerView.layoutManager=layoutManager
//        adapter=MyAdapter(nameDatas)
//        binding.mainRecyclerView.adapter=adapter
//        binding.mainRecyclerView.addItemDecoration(
//            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
//        )

    }

}