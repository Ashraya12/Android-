package com.ktm.aaryan


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {


    private lateinit var handler:Database



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        handler = Database(this)

       /* val db = Room.databaseBuilder(applicationContext,room_db::class.java,"UserDB").allowMainThreadQueries()*/

        l_login.setOnClickListener {


            if (l_username.text.isEmpty() || l_password.text.isEmpty()) {
                Toast.makeText(this@Login, "All fields are required", Toast.LENGTH_LONG)
                    .show()
            }
            else{
                if(handler.login(l_username.text.toString(),l_password.text.toString())){
                        Toast.makeText(this@Login, "Logged in", Toast.LENGTH_LONG)
                            .show()
                        startActivity(Intent(this,ListView::class.java))
                    }
                else{
                    Toast.makeText(this@Login, "Enter correct credentials", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }
}
