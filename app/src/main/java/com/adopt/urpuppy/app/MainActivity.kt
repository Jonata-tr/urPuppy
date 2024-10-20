package com.adopt.urpuppy.core.auth.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.adopt.urpuppy.R
import com.adopt.urpuppy.app.AdoptionFragment
import com.adopt.urpuppy.app.HomeFragment
import com.adopt.urpuppy.app.PreferencesFragment
import com.adopt.urpuppy.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

//Define um conjunto de metodos/funções, onde classes podem implementar ou não suas funções
interface MainCallBack {
    fun loadNavigation(fragment: Fragment)
    fun onLoginReturn()
}

class MainActivity : AppCompatActivity(), MainCallBack {

    private lateinit var binding : ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {

                R.id.bottom_home -> {
                    loadNavigation(HomeFragment())
                    true
                } R.id.bottom_pets -> {
                    loadNavigation(AdoptionFragment())
                    true
                } R.id.bottom_user -> {
                    loadNavigation(PreferencesFragment())
                    true
                }

                else -> false
            }

        }


    }


    //sobrescreve a implementação da função criada na interface
    override fun loadNavigation(fragment: Fragment) {
        supportFragmentManager.commit {
            setCustomAnimations (
                R.anim.slide_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_out
            )
            replace(R.id.main_fragment_container, fragment)
            addToBackStack(null)
        }

    }

    override fun onLoginReturn() {
        supportFragmentManager.popBackStack() //Remove o fragmento atual da pilha de atividades
    }
}