package com.example.recyclerviewudelp.Data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ConnectionDb(context: Context) : SQLiteOpenHelper(context,DATABASE_NAME, null,DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_TABLE)
    }

    fun openConnection(typeConnectionDb:Int):SQLiteDatabase{

        return when(typeConnectionDb){

            MODE_WRITE -> {
                writableDatabase
            }
            MODE_READ -> {
                readableDatabase
            }
            else ->{
                readableDatabase
            }
        }

    }

     companion object{
         private const val DATABASE_NAME = "MYLOSOFT"
         private const val DATABASE_VERSION = 1
         const val TABLE_EMPLOYEES = "CTL_EMPLOYEES"
         private const val CREATE_TABLE= "CREATE TABLE $TABLE_EMPLOYEES(Id INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR(20),Lastname VARCHAR(15),Gender INTEGER,Birthday DATE,Job VARCHAR(20))"
         private const val DROP_TABLE= "DROP TABLE IF EXISTS $TABLE_EMPLOYEES"
         const val MODE_WRITE=1
         const val MODE_READ=2
     }

}