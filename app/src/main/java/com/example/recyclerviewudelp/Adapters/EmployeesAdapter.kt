package com.example.recyclerviewudelp.Adapters

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewudelp.Data.EmployeeDb
import com.example.recyclerviewudelp.Data.EmployeeEntity
import com.example.recyclerviewudelp.DetailActivity
import com.example.recyclerviewudelp.R
import kotlinx.android.synthetic.main.item_employee.view.*


class EmployeesAdapter(val employeeList:ArrayList<EmployeeEntity>,val context: Context) : RecyclerView.Adapter<EmployeesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesHolder {

        val inflater = LayoutInflater.from(parent.context)
        return  EmployeesHolder(inflater.inflate(R.layout.item_employee,parent,false))

    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    override fun onBindViewHolder(holder: EmployeesHolder, position: Int) {

        val fullName="${employeeList[position].name} ${employeeList[position].lastName}"
        holder.txvName.text = fullName
        holder.txvGender.text =  if (employeeList[position].gender == 1) "Masculino" else "Femenino"
        holder.txvDateBirth.text= employeeList[position].birthday

        holder.btnDelete.setOnClickListener{

            val builder = AlertDialog.Builder(context)
            builder.setTitle(R.string.app_name)
            builder.setMessage("¿Desea eliminar al empleado '${employeeList[position].name} ${employeeList[position].lastName}' de la base de datos?")

            builder.setPositiveButton("SI"){ dialogInterface: DialogInterface, i: Int ->

                val employeeDb= EmployeeDb(context)
                val result = employeeDb.employeeDelete(employeeList[position].id)
                if(result>0){

                    val indexArray= employeeList.indexOf(employeeList[position])
                    employeeList.removeAt(indexArray)
                    notifyDataSetChanged()
                    Toast.makeText(context,"Elemento eliminado", Toast.LENGTH_LONG).show()

                }else {

                    Toast.makeText(context,"Ups!! no se eliminó nada",Toast.LENGTH_LONG).show()
                }

            }

            builder.setNegativeButton("NO"){ dialogInterface: DialogInterface, i: Int ->


            }

            builder.create().show()

        }

        holder.btnView.setOnClickListener{

            val intent = Intent(holder.itemView.context,DetailActivity::class.java)
            intent.putExtra("IdEmployee",employeeList[position].id.toString())
            holder.itemView.context.startActivity(intent)
        }
    }

}

class EmployeesHolder(view: View) : RecyclerView.ViewHolder(view){
    val imgPhoto = view.imvLogoItem
    val txvName =view.txvName
    val txvGender =view.txvGender
    val txvDateBirth =view.txvDateBirth
    val btnDelete = view.ibtDelete
    val btnView = view.ibtView
}