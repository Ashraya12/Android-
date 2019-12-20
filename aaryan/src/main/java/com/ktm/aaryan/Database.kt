package com.ktm.aaryan

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class Database(context: Context) : SQLiteOpenHelper(context,dbname,factory,version){
    override fun onCreate(db: SQLiteDatabase?) {


        val createTable = "CREATE TABLE " + TABLE_NAME +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COLUMN_UNAME + " VARCHAR(10),"+
                COLUMN_EMAIL + " VARCHAR(50),"+
                COLUMN_PASSWORD + " VARCHAR(20))"
        db!!.execSQL(createTable)

    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS USER")
        onCreate(db)
    }

    fun insertData(username: String, email: String, password: String):Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_UNAME, username)
        contentValues.put(COLUMN_EMAIL, email)
        contentValues.put(COLUMN_PASSWORD, password)

        val ins = db.insert(TABLE_NAME,null,contentValues)
        return !ins.equals(-1)
    }
    fun checkUser(username: String,password: String):Cursor{
        val db:SQLiteDatabase = this.writableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $COLUMN_UNAME = $username & $COLUMN_PASSWORD = $password",null)
    }

    /*fun CheckUser(username: String,password: String):Boolean{
        val db = this.readableDatabase

        val query =
            "select * from $TABLE_NAME where $COLUMN_UNAME = $username and $COLUMN_PASSWORD = $password"
        val cursor = db.rawQuery(query,null)
        return cursor.count > 0



    }*/






    companion object{
        internal const val dbname = "hellofusers"
        internal val factory = null
        internal const val version = 1

        private const val TABLE_NAME = "User"
        private const val COLUMN_ID = "ID"
        private const val COLUMN_UNAME = "Username"
        private const val COLUMN_PASSWORD = "Password"
        private const val COLUMN_EMAIL = "Email"
    }
}




