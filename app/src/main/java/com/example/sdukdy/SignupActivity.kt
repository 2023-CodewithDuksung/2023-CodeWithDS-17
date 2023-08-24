package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {
        private lateinit var etUsername : EditText
        private lateinit var etPassword : EditText
        private lateinit var btnSignup : Button
        private lateinit var auth : FirebaseAuth

        // 회원정보 연동
        private lateinit var editTextName : EditText
        private lateinit var editTextDepartment : EditText

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
        // 뒤로가기 눌렀을 때 홈으로 돌아가기
        findViewById<View>(R.id.h_back2).setOnClickListener {
            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
            startActivity(intent)
        }
        // 회원정보 가져오는 로직, 안되면 주석처리
        editTextName = findViewById(R.id.o_mypageRectangle0)
        editTextDepartment = findViewById(R.id.o_mypageRectangle2)

        val signupButton : Button = findViewById(R.id.allow)
        signupButton.setOnClickListener {
            // 사용자가 입력한 이름과 학과 정보 가져오기
            val enteredName = editTextName.text.toString()
            val enteredDepartment= editTextDepartment.text.toString()

            // Firebase Realtime Database에 회원가입 정보 저장
            saveUserInfoToFirebase(enteredName,enteredDepartment)
        }




        }
    private fun saveUserInfoToFirebase(name:String, department: String) {
        val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference.child("users")
        val userInfo = hashMapOf(
            "name" to name,
            "department" to department
        )
        databaseReference.child(user?.uid ?: "").setValue(userInfo)
            .addOnSuccessListener {
                // 회원가입 정보 저장 성공 처리
                val intent= Intent(this@SignupActivity,LoginActivity::class.java)
                startActivity(intent)
                // 예를 들어, 다음 화면으로 이동하는 코드 등을 추가할 수 있습니다.
            }
            .addOnFailureListener {
                // 회원가입 정보 저장 실패 처리
            }

    }

        // 페이지 이동
        fun moveToAnotherPage(){
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        // 함수호출


    }
