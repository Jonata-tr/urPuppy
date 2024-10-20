package com.adopt.urpuppy.core.auth.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.adopt.urpuppy.R
import com.adopt.urpuppy.databinding.LoginFragmentsBinding

//Define um conjunto de metodos/funções, onde classes podem implementar ou não suas funções
interface LoginCallBack {
    fun onCreateAccountClicked()
    fun onLoginReturn()
}

class LoginActivity : AppCompatActivity(), LoginCallBack {

    private lateinit var binding : LoginFragmentsBinding

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginFragmentsBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.fragmentContainerView
    }

    //sobrescreve a implementação da função criada na interface
    override fun onCreateAccountClicked() {
        val fragment = SingUpFragment()
        supportFragmentManager.commit {
            setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_out
            )
            replace(R.id.fragment_container_view, fragment)
            addToBackStack(null)
        }

    }

    override fun onLoginReturn() {
        supportFragmentManager.popBackStack() //Remove o fragmento atual da pilha de atividades
    }
}