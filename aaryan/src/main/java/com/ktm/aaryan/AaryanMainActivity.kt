package com.ktm.aaryan

import android.content.AsyncQueryHandler
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_aaryan_main.*

class AaryanMainActivity : AppCompatActivity() {

    lateinit var handler:database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aaryan_main)

        handler = database(this)

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
                val username = username.text
                val email = email.text.toString();
                val password = password.text

                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(this@AaryanMainActivity, "Enter valid email", Toast.LENGTH_LONG)
                        .show()
                }


            }



        })

        sign_up.setOnClickListener {
            val username = username.text;

            val email = email.text;

            val password = password.text;

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this@AaryanMainActivity, "All fields are required", Toast.LENGTH_LONG)
                    .show()
            }

            handler.insert_data(username.toString(),email.toString(),password.toString())


            val intent = Intent(this,login::class.java)
            startActivity(intent)
        }
    }
}
