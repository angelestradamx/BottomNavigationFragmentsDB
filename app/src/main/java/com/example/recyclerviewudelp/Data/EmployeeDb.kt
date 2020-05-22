package com.example.recyclerviewudelp.Data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log

class EmployeeDb {

    private val connectionDb:ConnectionDb
    private lateinit var sqlSQLiteDatabase: SQLiteDatabase

    constructor(context: Context){
        connectionDb= ConnectionDb(context)
    }

    fun employeeAdd(employee: EmployeeEntity): Long{

        val answer: Long
        sqlSQLiteDatabase=  connectionDb.openConnection(ConnectionDb.MODE_WRITE)

        val values= ContentValues()
        values.put(NAME,employee.name)
        values.put(LASTNAME,employee.lastName)
        values.put(GENDER,employee.gender)
        values.put(BIRTHDAY,employee.birthday)
        values.put(JOB,employee.job)

        answer = sqlSQLiteDatabase.insert(ConnectionDb.TABLE_EMPLOYEES,null,values)
        sqlSQLiteDatabase.close()

        return answer
    }

    fun employeeDelete(idEmployee: Int): Int{

        val answer: Int
        sqlSQLiteDatabase=  connectionDb.openConnection(ConnectionDb.MODE_WRITE)
        val selection = "$ID=?"
        val args = arrayOf(idEmployee.toString())

        answer = sqlSQLiteDatabase.delete(ConnectionDb.TABLE_EMPLOYEES,selection,args)
        sqlSQLiteDatabase.close()

        return answer
    }

    fun employeeGetAllText(){

        sqlSQLiteDatabase=  connectionDb.openConnection(ConnectionDb.MODE_READ)
        val fields  = arrayOf(ID, NAME, LASTNAME, GENDER, BIRTHDAY, JOB)

        val cursor =  sqlSQLiteDatabase.query(ConnectionDb.TABLE_EMPLOYEES,fields,null, null, null,null,null)

        if (cursor.moveToFirst()){

            do{
                Log.d("UDELP","${cursor.getInt(0)} ${cursor.getString(1)} ${cursor.getString(2)} ${cursor.getInt(3)}  ${cursor.getString(4)}  ${cursor.getString(5)}")
            }while (cursor.moveToNext())

        }

        sqlSQLiteDatabase.close()

    }


    fun employeeGetAll():ArrayList<EmployeeEntity>{

        val answer = ArrayList<EmployeeEntity>()

        sqlSQLiteDatabase=  connectionDb.openConnection(ConnectionDb.MODE_READ)
        val fields  = arrayOf(ID, NAME, LASTNAME, GENDER, BIRTHDAY, JOB)

        val cursor =  sqlSQLiteDatabase.query(ConnectionDb.TABLE_EMPLOYEES,fields,null, null, null,null,null)

        if (cursor.moveToFirst()){

            do{

                answer.add(
                    EmployeeEntity(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getString(5)
                    )
                )


            }while (cursor.moveToNext())

        }

        sqlSQLiteDatabase.close()
        return answer
    }




    fun employeeGetOne(idEmployee: Int):EmployeeEntity?{

        var answer: EmployeeEntity?=null

        sqlSQLiteDatabase=  connectionDb.openConnection(ConnectionDb.MODE_READ)
        val fields  = arrayOf(ID, NAME, LASTNAME, GENDER, BIRTHDAY, JOB)
        val selection = "$ID=?"
        val args = arrayOf(idEmployee.toString())

        val cursor =  sqlSQLiteDatabase.query(ConnectionDb.TABLE_EMPLOYEES,fields,selection, args, null,null,null)

        if (cursor.moveToFirst()){

                answer =  EmployeeEntity(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getString(5)
                    )

        }

        sqlSQLiteDatabase.close()
        return answer
    }






    companion object{
        private const val ID="Id"
        private const val NAME="Name"
        private const val LASTNAME="Lastname"
        private const val GENDER ="Gender"
        private const val BIRTHDAY = "Birthday"
        private const val JOB= "Job"

    }

}