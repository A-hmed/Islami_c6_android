package com.route.islami_c6.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.route.islami_c6.R
import com.route.islami_c6.ui.home.quran_fragment.FragmentQuran

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNavigation : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
            FragmentQuran()
        ).commit()
        bottomNavigation = findViewById(R.id.home_bottom_navigation)

//        bottomNavigation.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener{
//            override fun onNavigationItemSelected(item: MenuItem): Boolean {
//                return true
//            }
//        })
        bottomNavigation.setOnItemSelectedListener {item->
            if(item.itemId == R.id.ic_quran){
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    FragmentQuran()
                ).commit()
            }else if(item.itemId == R.id.ic_ahadeth){
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    FragmentAhadeth()).commit()
            }else if(item.itemId == R.id.ic_sebha){
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    FragmentSebha()).commit()
            }else {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    FragmentRadio()).commit()
            }
            return@setOnItemSelectedListener true
        }
    }
}