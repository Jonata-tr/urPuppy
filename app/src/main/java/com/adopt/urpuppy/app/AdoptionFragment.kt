package com.adopt.urpuppy.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.adopt.urpuppy.databinding.FragmentAdoptionBinding
import com.adopt.urpuppy.databinding.PetsRowBinding

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
    ) : View{
        _binding = FragmentAdoptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inboxAdapter = InboxAdapter()
        binding.petsList.adapter = inboxAdapter
    }

    private inner class InboxAdapter: RecyclerView.Adapter<InboxAdapter.RowView>() {
        private inner class RowView(view:  PetsRowBinding): RecyclerView.ViewHolder(view.root)

        //Cria o
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowView {
            val view = PetsRowBinding.inflate(layoutInflater, parent, false)
            return RowView(view)
        }

        //Quantidade de rows que serão renderizados
        override fun getItemCount(): Int {
            return 16
        }

        override fun onBindViewHolder(holder: RowView, position: Int) {
            //TOD("Not yet implemented")
        }
    }

}