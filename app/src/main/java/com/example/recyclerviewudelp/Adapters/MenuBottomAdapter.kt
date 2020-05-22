package com.example.recyclerviewudelp.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MenuBottomAdapter(val fragmentLis:ArrayList<Fragment>,fragmentManager: FragmentManager):
    FragmentStatePagerAdapter(fragmentManager,FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getItem(position: Int): Fragment {
        return fragmentLis[position]
    }

    override fun getCount(): Int {
        return fragmentLis.size
    }


}