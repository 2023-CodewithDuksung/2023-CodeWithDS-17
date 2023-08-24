package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SubjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject)

        findViewById<View>(R.id.o_subject_add1).setOnClickListener {
            val intent = Intent(this@SubjectActivity, TimeTableActivity::class.java)
            intent.putExtra("color", android.graphics.Color.CYAN)
            startActivity(intent)
        }

    }
}