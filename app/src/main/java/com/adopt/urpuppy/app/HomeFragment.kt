package com.adopt.urpuppy.app

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adopt.urpuppy.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    //Para evitar erros ao destruir uma activity, primeiramento criamos uma variavel _binding com o valor null (Enquanto a activity estiver ativa o
    // valor não sera nulo) e com isso usamos o get para passar o FragmentHomeBinding para a val binding.
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeCallBack : MainCallBack //Cria uma variavel chamada homecall back que sera do tipo homecallback

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
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

        //Adiciona o link das noticias aos card de noticia da home
        binding.news1.setOnClickListener{
            goToNewsSite("https://www.cnnbrasil.com.br/lifestyle/veja-as-racas-de-caes-e-gatos-mais-populares-no-mundo-segundo-pesquisa/")
        }

        binding.news2.setOnClickListener{
            goToNewsSite("https://www.cnnbrasil.com.br/lifestyle/alimentacao-natural-ou-racao-qual-a-melhor-dieta-para-seu-pet/")
        }

        binding.news3.setOnClickListener{
            goToNewsSite("https://www.cnnbrasil.com.br/economia/animal-de-estimacao-herdeiro-veja-o-caso-de-quem-deixa-os-bens-para-o-pet-nos-eua/")
        }

        binding.news4.setOnClickListener{
            goToNewsSite("https://www.cnnbrasil.com.br/lifestyle/semana-de-moda-de-nova-york-caes-ganham-as-passarelas-em-desfile-beneficente/")
        }

    }

    fun goToNewsSite( link: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(intent)
    }
}