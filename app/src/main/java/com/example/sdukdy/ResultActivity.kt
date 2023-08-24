package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sdukdy.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_result)

        val score = intent.getIntExtra("score", 0)
        val totalSize = intent.getIntExtra("totalSize", 0)

        binding.scoreText.text = getString(R.string.o_count_label, score, totalSize)

        binding.resetBtn.setOnClickListener {
            val intent = Intent(this@ResultActivity, QuizmainActivity::class.java)
            startActivity(intent)
        }
    }
}