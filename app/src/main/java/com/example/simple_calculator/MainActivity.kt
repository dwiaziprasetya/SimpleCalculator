package com.example.simple_calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    //TextView
    private lateinit var tvWorking:TextView
    private lateinit var tvResult:TextView

    //Button 1
    private lateinit var btnAC:Button
    private lateinit var btnDel:Button
    private lateinit var btnPersen:Button
    private lateinit var btnDiv:Button

    //Button 2
    private lateinit var btnSeven:Button
    private lateinit var btnEight:Button
    private lateinit var btnNine:Button
    private lateinit var btnMul:Button

    //Button 3
    private lateinit var btnFour:Button
    private lateinit var btnFive:Button
    private lateinit var btnSix:Button
    private lateinit var btnMinus:Button

    //Button 4
    private lateinit var btnOne:Button
    private lateinit var btnTwo:Button
    private lateinit var btnThree:Button
    private lateinit var btnPlus:Button

    //Button 5
    private lateinit var btnZero:Button
    private lateinit var btnDot:Button
    private lateinit var btnEquals:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inizialiation
        tvWorking = findViewById(R.id.tvWorking)
        tvResult = findViewById(R.id.tvResult)

        // 1
        btnAC = findViewById(R.id.btnC)
        btnDel = findViewById(R.id.btnDel)
        btnPersen = findViewById(R.id.btnPersen)
        btnDiv = findViewById(R.id.btnDivide)

        // 2
        btnSeven = findViewById(R.id.btnSeven)
        btnEight = findViewById(R.id.btnEight)
        btnNine = findViewById(R.id.btnNine)
        btnMul = findViewById(R.id.btnMultiple)

        // 3
        btnFour = findViewById(R.id.btnFour)
        btnFive = findViewById(R.id.btnFive)
        btnSix = findViewById(R.id.btnSix)
        btnMinus = findViewById(R.id.btnMinus)

        // 4
        btnOne = findViewById(R.id.btnOne)
        btnTwo = findViewById(R.id.btnTwo)
        btnThree = findViewById(R.id.btnThree)
        btnPlus = findViewById(R.id.btnPlus)

        // 5
        btnZero = findViewById(R.id.btnZero)
        btnDot = findViewById(R.id.btnComa)
        btnEquals = findViewById(R.id.btnEquals)

        // Set-on-click-listener

        // 1
        btnAC.setOnClickListener {
            tvWorking.text = ""
            tvResult.text = ""
        }
        btnDel.setOnClickListener {
            val length = tvWorking.length()
            if (length > 0) tvWorking.text = tvWorking.text.subSequence(0,length-1)
        }
        btnPersen.setOnClickListener {
            tvWorking.text = addToInputText("%")
        }
        btnDiv.setOnClickListener {
            tvWorking.text = addToInputText("/")
        }

        // 2
        btnSeven.setOnClickListener {
            tvWorking.text = addToInputText("7")
        }
        btnEight.setOnClickListener {
            tvWorking.text = addToInputText("8")
        }
        btnNine.setOnClickListener {
            tvWorking.text = addToInputText("9")
        }
        btnMul.setOnClickListener {
            tvWorking.text = addToInputText("*")
        }

        //3
        btnFour.setOnClickListener {
            tvWorking.text = addToInputText("4")
        }
        btnFive.setOnClickListener {
            tvWorking.text = addToInputText("5")
        }
        btnSix.setOnClickListener {
            tvWorking.text = addToInputText("6")
        }
        btnMinus.setOnClickListener {
            tvWorking.text = addToInputText("-")
        }

        // 4
        btnOne.setOnClickListener {
            tvWorking.text = addToInputText("1")
        }
        btnTwo.setOnClickListener {
            tvWorking.text = addToInputText("2")
        }
        btnThree.setOnClickListener {
            tvWorking.text = addToInputText("3")
        }
        btnPlus.setOnClickListener {
            tvWorking.text = addToInputText("+")
        }

        // 5
        btnZero.setOnClickListener {
            tvWorking.text = addToInputText("0")
        }
        btnDot.setOnClickListener {
            tvWorking.text = addToInputText(".")
        }
        btnEquals.setOnClickListener {
            showResult()
        }

    }

    private fun getInputExpression():String{
        var expression = tvWorking.text.replace(Regex("÷"),"/")
        expression = expression.replace(Regex("×"),"*")
        return expression
    }

    // Process
    @SuppressLint("SetTextI18n")
    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if(result.isNaN()){
                // Show Error Message
                tvResult.text = "Error"
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.red))
            }else{
                // Show Result
                tvResult.text = DecimalFormat("0.#######").format(result).toString()
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.color1))
            }
        }catch (e:Exception){
            // Show Error Message
            tvResult.text = "Error"
            tvResult.setTextColor(ContextCompat.getColor(this,R.color.red))
        }
    }

    // add input text
    private fun addToInputText(buttonValue:String):String{
        return "${tvWorking.text}$buttonValue"
    }

}