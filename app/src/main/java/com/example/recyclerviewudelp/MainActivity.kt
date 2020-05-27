package com.example.recyclerviewudelp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.recyclerviewudelp.Adapters.EmployeesAdapter
import com.example.recyclerviewudelp.Adapters.MenuBottomAdapter
import com.example.recyclerviewudelp.Data.EmployeeDb
import com.example.recyclerviewudelp.Data.EmployeeEntity
import com.example.recyclerviewudelp.Fragments.FormFragment
import com.example.recyclerviewudelp.Fragments.HomeFragment
import com.example.recyclerviewudelp.Fragments.ListFragment
import com.example.recyclerviewudelp.Tools.ApiRest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myApi= ApiRest(this@MainActivity)
        val answerApiRest= myApi.getAllString()
        Log.d("MI SERVICIO RESPONSE ACTIVITY MAIN!!","$answerApiRest")

        val menuAdapter = MenuBottomAdapter(initFragment(),supportFragmentManager)
        viewPager.adapter= menuAdapter

        navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){

                R.id.menuHome->{  viewPager.currentItem =0 }
                R.id.menuList->{  viewPager.currentItem =1 }
                R.id.menuForm->{  viewPager.currentItem =2 }
            }
            true
        }


        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

                navigationView.menu.getItem(position).isChecked = true

            }
        })



    }



    fun initFragment():ArrayList<Fragment>{

         return arrayListOf(
            HomeFragment.newInstance(),
            ListFragment.newInstance(),
            FormFragment.newInstance()
        )
    }

}
