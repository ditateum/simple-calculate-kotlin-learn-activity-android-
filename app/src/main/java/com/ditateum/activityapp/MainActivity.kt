package com.ditateum.activityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        private const val STATE_RESULT = "state_result"
    }

    private lateinit var editTextLength : EditText
    private lateinit var editTextWidth : EditText
    private lateinit var editTextHeight : EditText
    private lateinit var btnCalculate : Button
    private lateinit var textViewResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextLength = findViewById(R.id.editTextLength)
        editTextWidth = findViewById(R.id.editTextWidth)
        editTextHeight = findViewById(R.id.editTextHeight)
        textViewResult = findViewById(R.id.textViewResult)
        btnCalculate = findViewById(R.id.btn_calculate)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            textViewResult.text = result
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, textViewResult.text.toString())
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate) {
            val inputLength = editTextLength.text.toString().trim()
            val inputWidth = editTextWidth.text.toString().trim()
            val inputHeight = editTextHeight.text.toString().trim()

            var isEmptyField = false

            if (inputLength.isEmpty()){
                isEmptyField = true
                editTextLength.error = "Field ini tidak boleh kosong"
            }

            if (inputWidth.isEmpty()) {
                isEmptyField = true
                editTextWidth.error = "Field ini tidak boleh kosong"
            }

            if (inputHeight.isEmpty()) {
                isEmptyField = true
                editTextHeight.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyField) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()

                textViewResult.text = volume.toString()
            }


        }
    }
}