package com.ktm.aaryan

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


@Suppress("UNREACHABLE_CODE")
class database(context: Context) : SQLiteOpenHelper(context,dbname,factory,version){
    override fun onCreate(db: SQLiteDatabase?) {


        val create_table = "CREATE TABLE user " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "username VARCHAR(10),"+
                "email VARCHAR(50),"+
                "password VARCHAR(20)"
        db?.execSQL(create_table)

    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insert_data(username:String, email: String,password: String){
        val db:SQLiteDatabase = writableDatabase
        val value:ContentValues = ContentValues()
        value.put("username",username)
        value.put("email",email)
        value.put("password",password)

        db.insert("user",null,value)
        db.close()


    }

    fun check_user(username: String,password: String):Boolean{
        val db0 = writableDatabase
        val query = "select * from user where username=$username and password=$password"
        val cursor = db0.rawQuery(query,null)
        if (cursor.count <= 0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

    companion object{
        internal val dbname = "user"
        internal val factory = null
        internal val version = 1
    }
}
