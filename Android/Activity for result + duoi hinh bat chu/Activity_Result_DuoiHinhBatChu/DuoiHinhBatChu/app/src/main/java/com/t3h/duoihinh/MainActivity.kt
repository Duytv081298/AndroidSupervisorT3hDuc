package com.t3h.duoihinh

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val questions = arrayListOf<Question>()
    private var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initQuestions()
        updateQuestionContent()
        updateSuggest()
    }

    private fun updateSuggest(){
        val listAn = arrayListOf<Char>()
        val rd = Random()
        for (i in 0..15-questions.get(currentIndex).name.length){
            listAn.add(
                    (rd.nextInt(26) + 65).toChar()
            )
        }
        for (i in 0..questions.get(currentIndex).name.length-1){
            listAn.add(
                    questions.get(currentIndex).name[i]
            )
        }
//        Collections.sort(t, (o1, o2) -> {
//            return o1.compareTo(o2);
//        });
        Collections.sort(listAn, {o1, o2-> o1.compareTo(o2)})

        for (i in 0..llSuggest1.childCount-1){
            (llSuggest1.getChildAt(i) as Button).setText(
                    listAn.get(i).toString()
            )
        }
        for (i in 0..llSuggest2.childCount-1){
            (llSuggest2.getChildAt(i) as Button).setText(
                    listAn.get(i+8).toString()
            )
        }
    }

    private fun updateQuestionContent() {
        ivImg.setImageResource(
                questions.get(currentIndex).imageId
        )
        val numberQuestion = questions.get(currentIndex).name.length
        for (i in 0..Math.min(8-1, numberQuestion-1)){
            val btn = LayoutInflater.from(this)
                    .inflate(R.layout.button_anwser,
                            ll_1, false) as Button
            ll_1.addView(btn)
        }
        for (i in 8..numberQuestion-1){
            val btn = LayoutInflater.from(this)
                    .inflate(R.layout.button_anwser,
                            ll_1, false) as Button
            ll_2.addView(btn)
        }
    }

    private fun initQuestions() {
        questions.add(
                Question("aomua".toUpperCase(), R.drawable.aomua)
        )
        questions.add(
                Question("baocao".toUpperCase(), R.drawable.baocao)
        )
        questions.add(
                Question("canthiep".toUpperCase(), R.drawable.canthiep)
        )
        questions.add(
                Question("cattuong".toUpperCase(), R.drawable.cattuong)
        )
    }
}
