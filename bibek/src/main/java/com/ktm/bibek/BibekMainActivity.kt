package com.ktm.bibek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.view.View
import kotlinx.android.synthetic.main.activity_bibek_main.*

class BibekMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bibek_main)

        gonxt.setOnClickListener() {
            val intent = Intent(this,SecondMainActivity::class.java)
            startActivity(intent)

          }
    }

    fun Calc(v:View)
    {
        val n1=findViewById<EditText>(R.id.num1) as EditText
        val n2=findViewById<EditText>(R.id.num2) as EditText
        val res=findViewById<TextView>(R.id.result) as TextView
        val number1:Float
        val number2:Float
        val result:Float

        if(TextUtils.isEmpty(n1.text.toString())){
            n1.error="ENter number plz:"
            return
        }
        else{
            number1=n1.text.toString().toFloat()
        }

        if(TextUtils.isEmpty(n2.text.toString())){
            n2.error="ENter number plz:"
            return
        }
        else{
            number2=n2.text.toString().toFloat()
        }

        when(v.id) {
            R.id.add -> {
                result = number1 + number2
                res.text = result.toString()
            }
            R.id.sub -> {
                result = number1 - number2
                res.text = result.toString()
            }
            R.id.mul -> {
                result = number1 * number2
                res.text = result.toString()
            }
            R.id.div -> {
                if (number2 == 0.0F) {
                    Toast.makeText(this@BibekMainActivity, "Divide By Zero Error", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    result = number1 / number2
                    res.text = result.toString()
                }
            }
        }
    }

}
