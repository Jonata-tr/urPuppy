package com.adopt.urpuppy.core.auth.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is LoginCallBack){
            loginCallBack = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.goToSingUpBtn.setOnClickListener {
            loginCallBack.onCreateAccountClicked()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //Faz o _binding ficar nulo novamente, para deixar claro que aquele _binding foi "destruido"
        _binding = null
    }

}