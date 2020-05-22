package com.example.recyclerviewudelp.Fragments

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import com.example.recyclerviewudelp.Data.EmployeeDb
import com.example.recyclerviewudelp.Data.EmployeeEntity

import com.example.recyclerviewudelp.R
import kotlinx.android.synthetic.main.fragment_form.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


class FormFragment : Fragment() {

    private lateinit var  mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext= context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        txvDatePickerDialog.setOnClickListener{

            var year:Int
            var month:Int
            var day:Int

            if (txvDatePickerDialog.text.toString()=="Fecha de nacimiento")
            {
                val calendar= Calendar.getInstance()
                year = calendar.get(Calendar.YEAR)
                month = calendar.get(Calendar.MONTH)
                day = calendar.get(Calendar.DAY_OF_MONTH)
            }
            else
            {

                val myDate= txvDatePickerDialog.text.toString()
                val formatter = DateTimeFormatter.ofPattern("d-MM-yyyy")
                val date = LocalDate.parse(myDate, formatter)

                year = date.year
                month  = date.monthValue -1
                day  = date.dayOfMonth
            }


            val dpd = DatePickerDialog(mContext,
                DatePickerDialog.OnDateSetListener { datePicker: DatePicker, y: Int, m: Int, d: Int ->

                    val dayString = if (d !in 1..9) {
                        d.toString()
                    } else {
                        "0$d"
                    }

                    val monthString = if ((m+ 1) !in 1..9) {
                        (m+ 1).toString()
                    } else {
                        "0${m +1}"
                    }

                    txvDatePickerDialog.text = "$dayString-$monthString-$y"

                },year,month,day)

            dpd.show()

        }



        btnSave.setOnClickListener{

            val employeeDb= EmployeeDb(mContext)
            val gender= spnGender.selectedItemPosition

           val employee = EmployeeEntity(-1,
                edtName.text.toString().trim(),
                edtLastName.text.toString().trim(),
                gender,
                txvDatePickerDialog.text.toString(),
                edtJob.text.toString().trim()
            )

            val res=employeeDb.employeeAdd(employee)

            if(res>0) {
                Toast.makeText(mContext,"Empleado guardado", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(mContext,"Ups!! no se guardó nada", Toast.LENGTH_LONG).show()
            }


        }


    }


    companion object {
        @JvmStatic
        fun newInstance() = FormFragment()
    }

}
