package com.adopt.urpuppy.core.auth.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adopt.urpuppy.R
import com.adopt.urpuppy.databinding.FragmentSingupBinding

class SingUpFragment : Fragment() {

    //Para evitar erros ao destruir uma activity, primeiramento criamos uma variavel _binding com o valor null (Enquanto a activity estiver ativa o
    // valor não sera nulo) e com isso usamos o get para passar o FragmentSingupBinding para a val binding.
    private var _binding: FragmentSingupBinding? = null
    private val binding get() = _binding!!
    private lateinit var loginCallBack : LoginCallBack //Cria uma variavel chamada logincall back que sera do tipo logincallback

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        _binding = FragmentSingupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is LoginCallBack){
            loginCallBack = context
        }
    }

    //Quando a tela é criada, adiciona o icone de seta e o on clicklistener que fica
    // responsavel de voltar para a telad de login
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setNavigationIcon(R.drawable.back_arrow)
        binding.toolbar.setNavigationOnClickListener {
            loginCallBack.onLoginReturn()
            binding.singupBtn.visibility = View.GONE

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //Faz o _binding ficar nulo novamente, para deixar claro que aquele _binding foi "destruido"
        _binding = null
    }

}