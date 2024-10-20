package com.adopt.urpuppy.app

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adopt.urpuppy.core.auth.view.MainCallBack
import com.adopt.urpuppy.databinding.FragmentPreferencesBinding

class PreferencesFragment : Fragment() {

    //Para evitar erros ao destruir uma activity, primeiramento criamos uma variavel _binding com o valor null (Enquanto a activity estiver ativa o
    // valor não sera nulo) e com isso usamos o get para passar o FragmentPreferencesBinding para a val binding.
    private var _binding: FragmentPreferencesBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeCallBack : MainCallBack //Cria uma variavel chamada homecall back que sera do tipo homecallback

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        _binding = FragmentPreferencesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is MainCallBack){
            homeCallBack = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        //Faz o _binding ficar nulo novamente, para deixar claro que aquele _binding foi "destruido"
        _binding = null
    }

}