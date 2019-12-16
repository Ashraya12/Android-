package com.ktm.aaryan


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*




class login : AppCompatActivity() {


    public lateinit var handler:database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        handler = database(this)

        l_login.setOnClickListener {
            val username = l_username.text;



            val password = l_password.text;

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this@login, "All fields are required", Toast.LENGTH_LONG)
                    .show()
            }

            if(handler.check_user(username.toString(),password.toString())){
                Toast.makeText(this@login, "Successfully Logged in", Toast.LENGTH_LONG)
                    .show()
            }
            else{
                Toast.makeText(this@login, "Invalid user data", Toast.LENGTH_LONG)
                    .show()
            }
        }





    }
}
