package com.example.recyclerviewudelp.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewudelp.Adapters.EmployeesAdapter
import com.example.recyclerviewudelp.Data.EmployeeDb

import com.example.recyclerviewudelp.R
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onResume() {
        super.onResume()

        val employeeDb= EmployeeDb(mContext)
        val employeeList= employeeDb.employeeGetAll()
        val employeeAdapter = EmployeesAdapter(employeeList,mContext)

        val linearLayoutManager= LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        rvwEmployees.layoutManager=linearLayoutManager
        rvwEmployees.setHasFixedSize(true)
        rvwEmployees.adapter=employeeAdapter

    }


    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}
