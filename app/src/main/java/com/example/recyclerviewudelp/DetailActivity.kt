package com.example.recyclerviewudelp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewudelp.Data.EmployeeDb
import com.example.recyclerviewudelp.Fragments.DetailFragment
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id=intent.getStringExtra("IdEmployee")

        supportFragmentManager
            .beginTransaction()
            .add(R.id.containerDetail,DetailFragment.newInstance(id))
            .commit()


    }
}
