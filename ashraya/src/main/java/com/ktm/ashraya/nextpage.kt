package com.ktm.ashraya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_nextpage.*

class nextpage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nextpage)
        val handler =DatabaseHandler(this)

        val context = this

        button.setOnClickListener {
        val readData = handler.readData()
        val sb = StringBuffer()
            if (readData.count > 0){
                while (readData.moveToNext()){
                    sb.append("Id = ${readData.getString(0)}\n")
                    sb.append("Name = ${readData.getString(1)}\n")
                    sb.append("Password = ${readData.getString(2)}\n")
                }
                textView2.text = sb.toString()
                Toast.makeText(applicationContext,"Data Retrived...",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext,"Failed to Retrived...",Toast.LENGTH_LONG).show()
            }
        }

    }
}
