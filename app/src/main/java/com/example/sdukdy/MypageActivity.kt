package com.example.sdukdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import org.w3c.dom.Text

class MypageActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        findViewById<View>(R.id.o_mypage_profileChangeBtn).setOnClickListener {
            //ProfileAcitivy로 이동 (회원정보 수정 화살표 버튼)
            val intent = Intent(this@MypageActivity, ProfileActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.o_mypage_settingsBtn).setOnClickListener {
            //SettingsAcitivy로 이동 (설정 화살표 버튼)
            val intent = Intent(this@MypageActivity, SettingsActivity::class.java)
            startActivity(intent)
        }

        // 하단바 아이콘 버튼들
        findViewById<View>(R.id.o_mypage_homeicon).setOnClickListener {
            //HomeAcitivy로 이동
            val intent = Intent(this@MypageActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.o_mypage_calendar).setOnClickListener {
            //TimeTableAcitivy로 이동
            val intent = Intent(this@MypageActivity, TimeTableActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.o_mypage_chatting).setOnClickListener {
            //ChattingAcitivy로 이동
            val intent = Intent(this@MypageActivity, ChattingActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.o_mypage_logoutBtn).setOnClickListener {
            // 로그아웃 했을 때 다시 로그인 화면으로 이동, 메세지도 표시
            Toast.makeText(this, "정상적으로 로그아웃되었습니다.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MypageActivity, LoginActivity::class.java)
            startActivity(intent)

        }
        // 마이페이지 UI에서 이름과 학과 정보를 표시하는 TextView 추가
        val nameTextView: TextView = findViewById(R.id.o_mypage_nickname)
        val departmentTextView: TextView = findViewById(R.id.o_mypage_major)

        //마이페이지에서 데이터 가져오기
        val user : FirebaseUser? = FirebaseAuth.getInstance().currentUser
        val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference.child("users").child(user?.uid ?: "")

        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val name = snapshot.child("name").getValue(String::class.java)
                    val department = snapshot.child("department").getValue(String::class.java)

                    runOnUiThread {
                        nameTextView.text = "이름: $name"
                        departmentTextView.text = "학과: $department"
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // 데이터 가져오기 실패 처리
            }
        })







    }
}