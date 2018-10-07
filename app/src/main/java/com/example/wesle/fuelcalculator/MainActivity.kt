package com.example.wesle.fuelcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCalculate.setOnClickListener {

            val maxValueForAlcohol = calculate(txtGasoline.text.toString())
            val alcoholValue = txtAlcohol.text.toString().toDouble()
            val verifyCompensation = verifyCompensation(alcoholValue, maxValueForAlcohol)

            if(verifyCompensation){
                val diff = maxValueForAlcohol - alcoholValue
                Toast.makeText(this, "Abasteça com Alcool, você irá economizar:\nR$ "
                        + "%.2f".format(diff), Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,
                        "O valor máximo do alcool deveria ser de:\nR$ "
                                + "%.2f".format(maxValueForAlcohol)
                                + " abasteça com gasolina !",
                        Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun calculate (gasolineValue: String): Double{
        return  gasolineValue.toDouble() * 0.7
    }

    private fun verifyCompensation(alcoholValue: Double, maxValueForAlcohol : Double):Boolean{
        return maxValueForAlcohol > alcoholValue
    }
}
