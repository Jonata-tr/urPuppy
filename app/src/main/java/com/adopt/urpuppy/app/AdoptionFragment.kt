package com.adopt.urpuppy.app

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adopt.urpuppy.core.auth.view.MainCallBack
import com.adopt.urpuppy.databinding.FragmentAdoptionBinding

class AdoptionFragment : Fragment() {

    //Para evitar erros ao destruir uma activity, primeiramento criamos uma variavel _binding com o valor null (Enquanto a activity estiver ativa o
    // valor não sera nulo) e com isso usamos o get para passar o FragmentAdoptionBinding para a val binding.
    private var _binding: FragmentAdoptionBinding? = null
    private val binding get() = _binding!!
    private lateinit var adoptionCallBack : MainCallBack //Cria uma variavel chamada adoptioncall back que sera do tipo Maincallback

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        _binding = FragmentAdoptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is MainCallBack){
            adoptionCallBack = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: PRA TODO UNS TRECO AI
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //Faz o _binding ficar nulo novamente, para deixar claro que aquele _binding foi "destruido"
        _binding = null
    }

}