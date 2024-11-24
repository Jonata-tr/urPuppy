package com.adopt.urpuppy.app

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.adopt.urpuppy.R
import com.adopt.urpuppy.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

//Define um conjunto de metodos/funções, onde classes podem implementar ou não suas funções
interface MainCallBack {
    fun loadNavigation(fragment: Fragment)
    fun onPageReturnFragment()
}

class MainActivity : AppCompatActivity(), MainCallBack {

    private lateinit var binding : ActivityMainBinding

    //Cria uma variavel do tipo bottom navigation, ela vai ser usada para acessar cada item do menu e permitir que o fragment
    //seja trocado quando houver ação do click do usuario
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState : Bundle?) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

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

        //Impede que um item selecionado na bottomnavigation seja selecionavel novamente caso ele esteja
        //sendo renderizado no momento
        bottomNavigationView.setOnItemReselectedListener{ }
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
            //Muda o fragmento atual do main_fragment pelo fragmento passado ao clicar no item do menu
            replace(R.id.main_fragment_container, fragment)
        }

    }

    override fun onPageReturnFragment() {
        supportFragmentManager.popBackStack() //Remove o fragmento atual da pilha de atividades
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }
}