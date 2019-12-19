package com.ktm.sujan

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sujan_main.*


class SujanMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sujan_main)

        val name = Name.text
        val Password = password.text


        login.setOnClickListener() {
            val intent = Intent(this,SecondMainActivity::class.java)
            startActivity(intent)

            Toast.makeText(this@SujanMainActivity, "Logged in as $name", Toast.LENGTH_LONG).show()
            Toast.makeText(this@SujanMainActivity, "Logged in as $Password", Toast.LENGTH_LONG).show()
        }
    }
}

