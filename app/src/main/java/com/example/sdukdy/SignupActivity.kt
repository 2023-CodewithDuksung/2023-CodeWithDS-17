package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {
        private lateinit var etUsername : EditText
        private lateinit var etPassword : EditText
        private lateinit var btnSignup : Button
        private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // 로그인 로직 구현
        etUsername = findViewById(R.id.o_mypageRectangle)
        etPassword = findViewById(R.id.o_mypageRectangle1)
        btnSignup = findViewById(R.id.allow)

        auth = FirebaseAuth.getInstance()

        // 계정 생성 버튼
        btnSignup.setOnClickListener {
           val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            // 회원가입 로직 완성
            auth.createUserWithEmailAndPassword(username,password)
                .addOnCompleteListener(this) {
                        task ->
                    if(task.isSuccessful) {
                        // 회원가입 성공
                        Toast.makeText(this,"회원가입이 완료되었습니다.",Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        // 회원가입 실패
                        Toast.makeText(this, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
        }



        val find = findViewById<Button>(R.id.chevron)

        // 페이지 이동
        fun moveToAnotherPage(){
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        // 함수호출
        find.setOnClickListener{
            moveToAnotherPage()
        }

    }
}