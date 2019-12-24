package com.ktm.ashraya

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AshrayaMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ashraya_main)

    var login_btn = findViewById<Button>(R.id.login)
    var et_username = findViewById(R.id.username) as EditText
    var et_password = findViewById(R.id.password) as EditText

        val context = this

     fun ValidateUsername():Boolean {
             val Usernameinp:String = et_username.text.toString()
        if (Usernameinp.isEmpty()) {
            et_username.setError("Cant be empty")
            return@ValidateUsername false;
        }else if(Usernameinp.length>15){
            et_username.setError("Username too long")
            return@ValidateUsername false
        }
        else{
            et_username.setError(null)
            return@ValidateUsername true
        }
    }

       var  handler = DatabaseHandler(this)

        fun ValidatePassword():Boolean {
            val Passwordinp = et_password.text.toString()
            if (Passwordinp.isEmpty()) {
                et_password.setError("Cant be empty")
                return@ValidatePassword false
            }else if(Passwordinp.length>6){
                et_username.setError("Password too short")
                return@ValidatePassword false
            }
            else{
                et_password.setError(null)
                return@ValidatePassword true
            }
        }



    login_btn.setOnClickListener {

        val username = et_username.text.toString()
        val password  = et_password.text.toString()
        if (ValidatePassword() && ValidateUsername()){
            if(handler.insertData(UserL(username,password) )){
                Toast.makeText(this@AshrayaMainActivity,"Successful",Toast.LENGTH_LONG).show()

                val intent = Intent(this,nextpage::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this@AshrayaMainActivity,"Failed",Toast.LENGTH_LONG).show()
            }


        }
        else{
          Toast.makeText(this, "Invalid Username or password", Toast.LENGTH_LONG).show()
        }

    }

    }
}
