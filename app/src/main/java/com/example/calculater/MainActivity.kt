package com.example.calculater

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.calculater.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private  lateinit var tasarim:ActivityMainBinding
   // private var canAddAction=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim=ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        tasarim.btnESC.setOnClickListener {
            tasarim.textNumber.text=""
            tasarim.textResult.text="" }

        tasarim.btnBackSpace.setOnClickListener {
           // Snackbar.make(it,"calıstı",Snackbar.LENGTH_SHORT).show()
            val length=tasarim.textNumber.text.length
            if(length>0){
                tasarim.textNumber.text=tasarim.textNumber.text.substring(0,length-1)
            }
        }

        tasarim.btnPlus.setOnClickListener { tasarim.textNumber.append("+") }

        tasarim.btnZero.setOnClickListener { tasarim.textNumber.append("0")}
        tasarim.btnOne.setOnClickListener { tasarim.textNumber.append("1") }
        tasarim.btnTwo.setOnClickListener { tasarim.textNumber.append("2") }
        tasarim.btnThree.setOnClickListener { tasarim.textNumber.append("3") }
        tasarim.btnFour.setOnClickListener { tasarim.textNumber.append("4")}
        tasarim.btnFive.setOnClickListener { tasarim.textNumber.append("5") }
        tasarim.btnSix.setOnClickListener { tasarim.textNumber.append("6") }
        tasarim.btnSeven.setOnClickListener { tasarim.textNumber.append("7") }
        tasarim.btnEight.setOnClickListener { tasarim.textNumber.append("8") }
        tasarim.btnNine.setOnClickListener { tasarim.textNumber.append("9") }

        tasarim.btnEqual.setOnClickListener {
            val expression=ExpressionBuilder(tasarim.textNumber.text.toString()).build()
            val result=expression.evaluate()
            if(result.isFinite()) {
                try {
                    val result = expression.evaluate()
                    tasarim.textResult.text = result.toString()
                } catch (ex: Exception) {
                    tasarim.textNumber.text = "Error"
                }
            }
        }

    }
}