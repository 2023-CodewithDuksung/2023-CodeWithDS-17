package com.example.sdukdy

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.sdukdy.databinding.ActivityMainBinding
import com.example.sdukdy.databinding.ActivityQuizmainBinding

class QuizmainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityQuizmainBinding

    private var currentPosition: Int = 1
    private var selectedOption: Int = 0
    private var score: Int = 0

    private lateinit var questionList: ArrayList<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizmainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questionList = QuestionData.getQuestion()

        getQuestionData()

        binding.oOption1Text.setOnClickListener(this)
        binding.oOption2Text.setOnClickListener(this)
        binding.oOption3Text.setOnClickListener(this)
        binding.oOption4Text.setOnClickListener(this)

        binding.oSubmitBtn.setOnClickListener {

            if(selectedOption != 0){
                val question = questionList[currentPosition-1]

                if(selectedOption != question.correct_answer) {
                    setColor(selectedOption, R.drawable.o_wrong_option_background)

                    callDialog("오답", "정답 ${question.correct_answer}")
                }else{
                    score++
                }
                setColor(question.correct_answer, R.drawable.o_correct_option_background)

                if(currentPosition == questionList.size){
                    binding.oSubmitBtn.text = getString(R.string.o_submit, "끝")
                }else{
                    binding.oSubmitBtn.text = getString(R.string.o_submit, "다음")
                }
            }else{
                currentPosition++
                when{
                    currentPosition <= questionList.size -> {
                        getQuestionData()
                    }
                    else ->{
                        //결과 액티비티로 넘어감
                        //Toast.makeText(this, "끝", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@QuizmainActivity, ResultActivity::class.java)
                        intent.putExtra("score", score)
                        intent.putExtra("totalSize", questionList.size)
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedOption = 0

        }


    }
    private fun setColor(opt: Int, color: Int){
        when(opt){
            1 -> binding.oOption1Text.background = ContextCompat.getDrawable(this, color)
            2 -> binding.oOption2Text.background = ContextCompat.getDrawable(this, color)
            3 -> binding.oOption3Text.background = ContextCompat.getDrawable(this, color)
            4 -> binding.oOption4Text.background = ContextCompat.getDrawable(this, color)
        }
    }

    private fun callDialog(alertTitle: String, correctAnswer: String){
        AlertDialog.Builder(this)
            .setTitle(alertTitle)
            .setMessage("정답: $correctAnswer")
            .setPositiveButton("ok"){
                dialogInterface, i ->
                dialogInterface.dismiss()
            }
            .setCancelable(false)
            .show()
    }

    private fun getQuestionData() {

        setOptionStyle()

        val question = questionList[currentPosition - 1]

        binding.oProgressBar.progress = currentPosition

        binding.oProgressBar.max = questionList.size

        binding.oProgressText.text =
            getString(R.string.o_count_label, currentPosition, questionList.size)

        binding.oQuestionText.text = question.question

        binding.oOption1Text.text = question.option_one
        binding.oOption2Text.text = question.option_two
        binding.oOption3Text.text = question.option_three
        binding.oOption4Text.text = question.option_four

        setSubmitBtn("제출")
    }

    private fun setSubmitBtn(name: String) {
        binding.oSubmitBtn.text = getString(R.string.o_submit, name)
    }

    private fun setOptionStyle() {

        var optionList: ArrayList<TextView> = arrayListOf()
        optionList.add(binding.oOption1Text)
        optionList.add(binding.oOption2Text)
        optionList.add(binding.oOption3Text)
        optionList.add(binding.oOption4Text)

        for (op in optionList) {
            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.o_option_background)
            op.typeface = Typeface.DEFAULT_BOLD
        }
    }

    private fun selectedOptionStyle(view: TextView, opt: Int){
        setOptionStyle()

        selectedOption = opt
        view.setTextColor((Color.parseColor("#5F00FF")))
        view.background = ContextCompat.getDrawable(this, R.drawable.o_selected_option_background)
        view.typeface = Typeface.DEFAULT_BOLD
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.o_option1_text -> selectedOptionStyle(binding.oOption1Text,1)
            R.id.o_option2_text -> selectedOptionStyle(binding.oOption2Text,2)
            R.id.o_option3_text -> selectedOptionStyle(binding.oOption3Text,3)
            R.id.o_option4_text -> selectedOptionStyle(binding.oOption4Text,4)

        }
    }


}