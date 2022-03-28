package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.calculator.views.calculatorNumTwo
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculeterOne = calculatorOne()
        val calculatorNumTwo = calculatorNumTwo()

        makeCurrentFragment(calculeterOne)
        bottom_navigation.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.item1 -> makeCurrentFragment(calculeterOne)
                R.id.item2 -> makeCurrentFragment(calculatorNumTwo)
            }
            true

        }
    }

    private fun makeCurrentFragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.containerFragment, fragment)
        commit()

    }

}