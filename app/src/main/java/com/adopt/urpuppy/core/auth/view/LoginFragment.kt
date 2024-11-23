package com.adopt.urpuppy.core.auth.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adopt.urpuppy.app.MainActivity
import com.adopt.urpuppy.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    //Para evitar erros ao destruir uma activity, primeiramento criamos uma variavel _binding com o valor null (Enquanto a activity estiver ativa o
    // valor não sera nulo) e com isso usamos o get para passar o FragmentLoginBinding para a val binding.
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var loginCallBack : LoginCallBack //Cria uma variavel chamada logincall back que sera do tipo logincallback

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    //Atualiza o contexto quando a tela de login é criada
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is LoginCallBack){
            loginCallBack = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //Pega e armeza os dados de login do usuario nas preferencias do aplicativo
        val sharedPreferences = requireActivity().getSharedPreferences("urPuppy", Context.MODE_PRIVATE)
        val noAccountLoggedInOption = sharedPreferences.getBoolean("noAccountLoggedInOption", false)

        //Confere se o usuario decidiu entrar sem fazer login ou não
        if (noAccountLoggedInOption) {
            loginUser()

        } else {

            binding.loginBtn.setOnClickListener {
                loginUser()
            }

            //Entrar sem criar ou logar com uma conta
            binding.noAccountButton.setOnClickListener {

                val sharedPreferences = requireActivity().getSharedPreferences("urPuppy", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putBoolean("noAccountLoggedInOption", true)
                editor.apply()

                val intent = Intent(context, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                activity?.finish()
            }

            //Puxa a tela de cadastro
            binding.goToSingUpBtn.setOnClickListener {
                loginCallBack.onCreateAccountClicked()
            }

            super.onViewCreated(view, savedInstanceState)
        }

    }

    private fun loginUser(){
        val intent = Intent(context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        activity?.finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //Faz o _binding ficar nulo novamente, para deixar claro que aquele _binding foi "destruido"
        _binding = null
    }
}