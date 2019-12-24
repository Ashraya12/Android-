package com.ktm.ashraya

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val DATABASE_Name = "MyDb"
val TABLE_Name = "Users"
val COL_Name = "Username"
val COL_Password = "Password"
val COL_Id = "Id"

class DatabaseHandler(context: Context) :SQLiteOpenHelper(context,DATABASE_Name,null,1){
    override fun onCreate(p0: SQLiteDatabase?) {

        val createTable = "CREATE TABLE " + TABLE_Name + " (" + COL_Id + " Integer primary key autoincrement," + COL_Name + " VARCHAR(256)," + COL_Password + " String) ";
        p0!!.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
         //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(user: UserL):Boolean{
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_Name,user.name)
        cv.put(COL_Password,user.password)
        var result = db.insert(TABLE_Name,null,cv)
        if (result == -1.toLong())
            return false
        else
            return true




    }

    fun readData():Cursor {
        val db = this.readableDatabase
        val Cursor = db.rawQuery("SELECT * FROM $TABLE_Name",null)
        return Cursor
    }

}

