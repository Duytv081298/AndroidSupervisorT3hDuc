package com.example.updateviewmodel.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter

class SongPageAdapter(fm: FragmentManager, behavior: Int) :
    FragmentPagerAdapter(fm, behavior) {

    override fun getItem(position: Int): Fragment {
        val fr = SongFragment()
        when (position) {
            0 -> fr.firstSearch = ""
            1 -> fr.firstSearch = "Xa em"
            2 -> fr.firstSearch = "Thich thi den"
            3 -> fr.firstSearch = "Lac troi"
        }
        return fr
    }

    override fun getCount(): Int {
        return 4
    }

    //hien thi ten o tren tablayout
    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Default"
            1 -> return "Xa em"
            2 -> return "Thich thi den"
            3 -> return "Lac troi"
        }
        return ""
    }
}