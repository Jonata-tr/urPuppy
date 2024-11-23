package com.adopt.urpuppy.app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.adopt.urpuppy.R
import com.adopt.urpuppy.databinding.FragmentAdoptionBinding
import com.adopt.urpuppy.puppysData.PuppyAdapter
import com.adopt.urpuppy.puppysData.PuppysDataClass

class AdoptionFragment : Fragment() {

    //Para evitar erros ao destruir uma activity, primeiramento criamos uma variavel _binding com o valor null (Enquanto a activity estiver ativa o
    // valor não sera nulo) e com isso usamos o get para passar o FragmentAdoptionBinding para a val binding.
    private var _binding: FragmentAdoptionBinding? = null
    private val binding get() = _binding!!
    private lateinit var adoptionCallBack : MainCallBack //Cria uma variavel chamada adoptioncall back que sera do tipo Maincallback

    private lateinit var recyclerView: RecyclerView
    private lateinit var puppyList: ArrayList<PuppysDataClass>
    lateinit var puppyImage:Array<Int>
    private lateinit var puppyName:Array<String>
    private lateinit var puppyRace:Array<String>
    private lateinit var puppyAge:Array<String>
    private lateinit var puppySex:Array<String>
    private lateinit var puppyLocation:Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View{

        _binding = FragmentAdoptionBinding.inflate(inflater,  container, false)

        puppyImage = arrayOf(
            R.drawable.desgracadinho,
            R.drawable.dog1,
            R.drawable.dog2,
            R.drawable.dog3,
            R.drawable.dog4,
            R.drawable.dog5,

        )

        puppyName = arrayOf(
            "Aleatorio",
            "Aleatorio",
            "Aleatorio",
            "Aleatorio",
            "Aleatorio",
            "Aleatorio",

        )
        puppySex = arrayOf(
            "Aleatorio",
            "Aleatorio",
            "Aleatorio",
            "Aleatorio",
            "Aleatorio",
            "Aleatorio",

        )
        puppyLocation = arrayOf(
            "Aleatorio",
            "Aleatorio",
            "Aleatorio",
            "Aleatorio",
            "Aleatorio",
            "Aleatorio",

        )
        puppyAge = arrayOf(
            "3 meses",
            "1 ano",
            "2 anos",
            "4 meses",
            "3 meses",
            "1 ano",
        )

        puppyRace = arrayOf(
            "aleatorio",
            "aleatorio",
            "aleatorio",
            "aleatorio",
            "aleatorio",
            "aleatorio",
        )


        recyclerView = binding.petsList
        recyclerView.setHasFixedSize(true)
        puppyList = arrayListOf<PuppysDataClass>()
        getDogData()

        return binding.root

    }

    private fun getDogData() {
        for (i in puppyImage.indices) {
            val dataClass = PuppysDataClass(
                puppyImage[i],
                puppyName[i],
                puppyAge[i],
                puppyLocation[i],
                puppySex[i],
                puppyRace[i],
            )
            puppyList.add(dataClass)
        }
        val adapter = PuppyAdapter(puppyList)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : PuppyAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {

                val intent = Intent(context, DetailedDescription::class.java)
                intent.putExtra("petImage", puppyList[position].puppyImage)
                intent.putExtra("petName", puppyList[position].puppyName)
                intent.putExtra("petSex", puppyList[position].puppySex)
                intent.putExtra("petLocation", puppyList[position].puppyLocation)
                intent.putExtra("petAge", puppyList[position].puppyAge)
                intent.putExtra("petRace", puppyList[position].puppyRace)

                startActivity(intent)
            }
        })
    }
}