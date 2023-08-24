package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    //로그인 처리
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnlogin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.o_mypageRectangle1)
        etPassword = findViewById(R.id.o_mypageRectangle2)
        btnlogin = findViewById(R.id.login)

        btnlogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            FirebaseAuth.getInstance().signInWithEmailAndPassword(username,password)
                .addOnCompleteListener{task->
                    if(task.isSuccessful) {
                        // 로그인 성공
                        val user = task.result?.user
                        Toast.makeText(this, "로그인에 성공하였습니다!", Toast.LENGTH_SHORT).show()
                        // 로그인 성공 후 다음 화면으로 이동하는 로직
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                        finish() // 로그인 화면을 종료하여 뒤로 가기 버튼으로 다시 돌아갈 수 없도록 합니다.
                    }
                    else {
                        // 로그인 실패
                        val exception = task.exception
                        Toast.makeText(this, "로그인 실패: $exception", Toast.LENGTH_SHORT).show()
                        // 실패에 대한 처리 로직을 추가하세요

                    }
                }
        }






        // 회원가입 창으로 이동
        findViewById<View>(R.id.find).setOnClickListener {
            val intent = Intent(this@LoginActivity, SignupActivity::class.java)
            startActivity(intent)
        }




        // 여기다 코드 복사
        val chevron = findViewById<Button>(R.id.find)
        // 페이지 이동
        fun moveToAnotherPage(){
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        // 함수호출
        chevron.setOnClickListener{
            moveToAnotherPage()
        }
        // 로그아웃 버튼 눌렀을 때 로그아웃되었습니다. 라는 창과 함께 로그인 창으로 회귀





    }
}