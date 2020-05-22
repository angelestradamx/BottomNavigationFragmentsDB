package com.example.recyclerviewudelp.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerviewudelp.Data.EmployeeDb

import com.example.recyclerviewudelp.R
import kotlinx.android.synthetic.main.fragment_detail.*


private const val ARG_ID_EMPLOYEE = "IdEmployee"

class DetailFragment : Fragment() {

    private lateinit var idEmployee: String
    private lateinit var  mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext= context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idEmployee=  it.getString(ARG_ID_EMPLOYEE).toString()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val employeeDb = EmployeeDb(mContext)
        val employee= employeeDb.employeeGetOne(idEmployee.toInt())
        txvFullName.text = "${employee?.name} ${employee?.lastName}"
        txvGender.text= if (employee?.gender == 1) "Masculino" else "Femenino"
        txvBirthday.text = employee?.birthday
        txvJob.text = employee?.job

    }

    companion object{
        @JvmStatic
        fun newInstance(param1:String) = DetailFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_ID_EMPLOYEE,param1)
            }
        }
    }

}
