package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sdukdy.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.jCreateButton.setOnClickListener{
            val chatRoomName = binding.jChattingNameEdit.text.toString()

            val intent = Intent(this, RecruitActivity::class.java)
            intent.putExtra("chatRoomName",chatRoomName)

            // 모집인원
            val peoplec = binding.jPeopleNumberEdit.text.toString()

            val intent2= Intent(this, RecruitActivity::class.java)
            intent2.putExtra("peoplec",peoplec)
            startActivity(intent)


            finish()
        }


    }
}