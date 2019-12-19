package com.ktm.aaryan


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_aaryan_main.*
import kotlinx.android.synthetic.main.activity_login.*




class Login : AppCompatActivity() {


    private lateinit var handler:Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        handler = Database(this)

       /* val db = Room.databaseBuilder(applicationContext,room_db::class.java,"UserDB").allowMainThreadQueries()*/

        l_login.setOnClickListener {
            val username0 = l_username.text



            val password0 = l_password.text

            if (username0.isEmpty() || password0.isEmpty()) {
                Toast.makeText(this@Login, "All fields are required", Toast.LENGTH_LONG)
                    .show()
            }

            /*db.usrDAO().checkUser()*/

            /*if(handler.CheckUser(username0.toString(),email.toString())){
                Toast.makeText(this@Login, "Successfully Logged in", Toast.LENGTH_LONG)
                    .show()
            }
            else{
                Toast.makeText(this@Login, "Invalid user data", Toast.LENGTH_LONG)
                    .show()
            }*/
        }





    }
}
