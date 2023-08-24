package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sdukdy.databinding.ActivityHomeBinding
import com.example.sdukdy.databinding.ActivityRecruitBinding
import com.example.sdukdy.databinding.ActivityRecruit3Binding

class RecruitActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityRecruit3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecruit3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.chevron.setOnClickListener {
            val intent = Intent(this, RecruitActivity::class.java)
            startActivity(intent)
        }

        val chatRoomName2 = intent.getStringExtra("chatRoomName2")
        binding.hDatast4.text= chatRoomName2
    }


}