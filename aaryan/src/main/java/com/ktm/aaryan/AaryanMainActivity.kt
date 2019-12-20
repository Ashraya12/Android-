package com.ktm.aaryan


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_aaryan_main.*


class AaryanMainActivity : AppCompatActivity() {

    private lateinit var handler:Database


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aaryan_main)

        handler = Database(this)


        /*var db = Room.databaseBuilder(applicationContext,room_db::class.java,"UserDB").build()*/



        email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {

            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {

                val email = email.text.toString()


                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(this@AaryanMainActivity, "Enter valid email", Toast.LENGTH_LONG)
                        .show()
                }
            }
        })

        sign_up.setOnClickListener {

            val intent = Intent(this@AaryanMainActivity,ListView::class.java)
            startActivity(intent)

            val username = username.text

            val email = email.text

            val password = password.text

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this@AaryanMainActivity, "All fields are required", Toast.LENGTH_LONG)
                    .show()
            }

        }

            if(handler.insertData(username.toString(),email.toString(),password.toString())){

                Toast.makeText(this@AaryanMainActivity, "User created successfully", Toast.LENGTH_LONG)
                    .show()
                val intent = Intent(this@AaryanMainActivity,Login::class.java)
                startActivity(intent)
            }
        else{
                Toast.makeText(this@AaryanMainActivity, "User creation error", Toast.LENGTH_LONG)
                    .show()
            }

        }
}


