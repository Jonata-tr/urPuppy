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
    private lateinit var puppyImage:Array<Int>
    private lateinit var puppyName:Array<String>
    private lateinit var puppyRace:Array<String>
    private lateinit var puppyAge:Array<String>
    private lateinit var petSize:Array<String>
    private lateinit var petSex:Array<String>
    private lateinit var petDescription:Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View{

        _binding = FragmentAdoptionBinding.inflate(inflater,  container, false)

        puppyImage = arrayOf(
            R.drawable.desgracadinho,

            R.drawable.gato1, //2

            R.drawable.dog1,
            R.drawable.dog2,

            R.drawable.gato2,//5
            R.drawable.gato3,

            R.drawable.mel, //Botar o da mel aq

            R.drawable.gato4,//8
            R.drawable.gato5,

            R.drawable.dog4,
            R.drawable.dog5,

            R.drawable.gato6,//12

            R.drawable.dog6,
            R.drawable.dog1,

            R.drawable.gato7,//15

            R.drawable.dog7,

            R.drawable.gata,//17
            R.drawable.symon,
            R.drawable.gato,

            )

        puppyName = arrayOf(
            "Trovão",
            "Neve",
            "Gigante",
            "Algodão",
            "Spook",
            "Lennon",
            "Mel", //Dog6 é a mel
            "Youtube",
            "Twitter",
            "Pulga", //
            "Rebaixado",
            "Maya",
            "Marley",
            "Zeca",
            "Tobby",
            "Chule",
            "Gata",
            "Symon",
            "Minecraft",
            )

        //O sexo ta invertido com a localização, ajeitar depois
        petSize = arrayOf(
            "Pequeno",
            "Pequeno",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "pequeno",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
        )
        petSex = arrayOf(
            "Macho",
            "Femea",
            "Macho",
            "Femea",
            "Macho",
            "Femea",
            "Macho",
            "Femea",
            "Macho",
            "Femea",
            "Macho",
            "Femea",
            "Macho",
            "Femea",
            "Macho",
            "Femea",
            "Femea",
            "Macho",
            "Macho",
        )
        puppyAge = arrayOf(
            "3 meses",
            "1 ano",
            "2 anos",
            "4 meses",
            "3 meses",
            "1 ano",
            "5 anos",
            "6 meses",
            "3 anos",
            "6 anos",
            "1 ano",
            "5 anos",
            "3 anos",
            "3 anos",
            "6 anos",
            "1 ano",
            "5 anos",
            "6 meses",
            "3 anos",
            "6 anos"
        )
        puppyRace = arrayOf(
            "Indefinido",
            "Indefinido",
            "Golden",
            "Mason",
            "Mormon",
            "Indefinido",
            "Caramelo",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",
            "Indefinido",

        )

        petDescription = arrayOf(

            "Ele é daqueles que adora seguir você pela casa, como se dissesse: \"Estou aqui " + "para o que precisar!\". Embora seja um excelente cão de guarda, ele tem um lado doce e travesso: ama correr atrás de bolinhas e buscar gravetos no parque. Seus olhos atentos e focados se iluminam toda vez que alguém pega uma coleira, pronto para explorar o mundo ao seu lado. Thor é leal, protetor e um amigo para todas as horas.",

            "Ela ama carinhos na barriga e pode passar horas deitada ao seu lado, apenas aproveitando sua companhia. Mas não se engane! Quando ela " +
                    "vê uma trilha ou um espaço aberto, seu espírito aventureiro desperta. Ela é perfeita para quem busca um equilíbrio entre " +
                    "tranquilidade e diversão. Com ela, cada dia é uma nova oportunidade para explorar e se conectar.",


            "Ele é daqueles que adora seguir você pela casa, como se dissesse: \"Estou aqui " + "para o que precisar!\". Embora seja um excelente cão de guarda, ele tem um lado doce e travesso: ama correr atrás de bolinhas e buscar gravetos no parque. Seus olhos atentos e focados se iluminam toda vez que alguém pega uma coleira, pronto para explorar o mundo ao seu lado. Thor é leal, protetor e um amigo para todas as horas.",

            "Ela ama carinhos na barriga e pode passar horas deitada ao seu lado, apenas aproveitando sua companhia. Mas não se engane! Quando ela " +
                    "vê uma trilha ou um espaço aberto, seu espírito aventureiro desperta. Ela é perfeita para quem busca um equilíbrio entre " +
                    "tranquilidade e diversão. Com ela, cada dia é uma nova oportunidade para explorar e se conectar.",


            "Ele é daqueles que adora seguir você pela casa, como se dissesse: \"Estou aqui " + "para o que precisar!\". Embora seja um excelente cão de guarda, ele tem um lado doce e travesso: ama correr atrás de bolinhas e buscar gravetos no parque. Seus olhos atentos e focados se iluminam toda vez que alguém pega uma coleira, pronto para explorar o mundo ao seu lado. Thor é leal, protetor e um amigo para todas as horas.",

            "Ela ama carinhos na barriga e pode passar horas deitada ao seu lado, apenas aproveitando sua companhia. Mas não se engane! Quando ela " +
                    "vê uma trilha ou um espaço aberto, seu espírito aventureiro desperta. Ela é perfeita para quem busca um equilíbrio entre " +
                    "tranquilidade e diversão. Com ela, cada dia é uma nova oportunidade para explorar e se conectar.",


            "Ele é daqueles que adora seguir você pela casa, como se dissesse: \"Estou aqui " + "para o que precisar!\". Embora seja um excelente cão de guarda, ele tem um lado doce e travesso: ama correr atrás de bolinhas e buscar gravetos no parque. Seus olhos atentos e focados se iluminam toda vez que alguém pega uma coleira, pronto para explorar o mundo ao seu lado. Thor é leal, protetor e um amigo para todas as horas.",

            "Ela ama carinhos na barriga e pode passar horas deitada ao seu lado, apenas aproveitando sua companhia. Mas não se engane! Quando ela " +
                    "vê uma trilha ou um espaço aberto, seu espírito aventureiro desperta. Ela é perfeita para quem busca um equilíbrio entre " +
                    "tranquilidade e diversão. Com ela, cada dia é uma nova oportunidade para explorar e se conectar.",


            "Ele é daqueles que adora seguir você pela casa, como se dissesse: \"Estou aqui " + "para o que precisar!\". Embora seja um excelente cão de guarda, ele tem um lado doce e travesso: ama correr atrás de bolinhas e buscar gravetos no parque. Seus olhos atentos e focados se iluminam toda vez que alguém pega uma coleira, pronto para explorar o mundo ao seu lado. Thor é leal, protetor e um amigo para todas as horas.",

            "Ela ama carinhos na barriga e pode passar horas deitada ao seu lado, apenas aproveitando sua companhia. Mas não se engane! Quando ela " +
                    "vê uma trilha ou um espaço aberto, seu espírito aventureiro desperta. Ela é perfeita para quem busca um equilíbrio entre " +
                    "tranquilidade e diversão. Com ela, cada dia é uma nova oportunidade para explorar e se conectar.",


            "Ele é daqueles que adora seguir você pela casa, como se dissesse: \"Estou aqui " + "para o que precisar!\". Embora seja um excelente cão de guarda, ele tem um lado doce e travesso: ama correr atrás de bolinhas e buscar gravetos no parque. Seus olhos atentos e focados se iluminam toda vez que alguém pega uma coleira, pronto para explorar o mundo ao seu lado. Thor é leal, protetor e um amigo para todas as horas.",

            "Ela ama carinhos na barriga e pode passar horas deitada ao seu lado, apenas aproveitando sua companhia. Mas não se engane! Quando ela " +
                    "vê uma trilha ou um espaço aberto, seu espírito aventureiro desperta. Ela é perfeita para quem busca um equilíbrio entre " +
                    "tranquilidade e diversão. Com ela, cada dia é uma nova oportunidade para explorar e se conectar.",


            "Ele é daqueles que adora seguir você pela casa, como se dissesse: \"Estou aqui " + "para o que precisar!\". Embora seja um excelente cão de guarda, ele tem um lado doce e travesso: ama correr atrás de bolinhas e buscar gravetos no parque. Seus olhos atentos e focados se iluminam toda vez que alguém pega uma coleira, pronto para explorar o mundo ao seu lado. Thor é leal, protetor e um amigo para todas as horas.",

            "Ela ama carinhos na barriga e pode passar horas deitada ao seu lado, apenas aproveitando sua companhia. Mas não se engane! Quando ela " +
                    "vê uma trilha ou um espaço aberto, seu espírito aventureiro desperta. Ela é perfeita para quem busca um equilíbrio entre " +
                    "tranquilidade e diversão. Com ela, cada dia é uma nova oportunidade para explorar e se conectar.",


            "Ele é daqueles que adora seguir você pela casa, como se dissesse: \"Estou aqui " + "para o que precisar!\". Embora seja um excelente cão de guarda, ele tem um lado doce e travesso: ama correr atrás de bolinhas e buscar gravetos no parque. Seus olhos atentos e focados se iluminam toda vez que alguém pega uma coleira, pronto para explorar o mundo ao seu lado. Thor é leal, protetor e um amigo para todas as horas.",

            "Ela ama carinhos na barriga e pode passar horas deitada ao seu lado, apenas aproveitando sua companhia. Mas não se engane! Quando ela " +
                    "vê uma trilha ou um espaço aberto, seu espírito aventureiro desperta. Ela é perfeita para quem busca um equilíbrio entre " +
                    "tranquilidade e diversão. Com ela, cada dia é uma nova oportunidade para explorar e se conectar.",


            "Ele é daqueles que adora seguir você pela casa, como se dissesse: \"Estou aqui " + "para o que precisar!\". Embora seja um excelente cão de guarda, ele tem um lado doce e travesso: ama correr atrás de bolinhas e buscar gravetos no parque. Seus olhos atentos e focados se iluminam toda vez que alguém pega uma coleira, pronto para explorar o mundo ao seu lado. Thor é leal, protetor e um amigo para todas as horas.",

            "Ela ama carinhos na barriga e pode passar horas deitada ao seu lado, apenas aproveitando sua companhia. Mas não se engane! Quando ela " +
                    "vê uma trilha ou um espaço aberto, seu espírito aventureiro desperta. Ela é perfeita para quem busca um equilíbrio entre " +
                    "tranquilidade e diversão. Com ela, cada dia é uma nova oportunidade para explorar e se conectar.",


            "Ele é daqueles que adora seguir você pela casa, como se dissesse: \"Estou aqui " + "para o que precisar!\". Embora seja um excelente cão de guarda, ele tem um lado doce e travesso: ama correr atrás de bolinhas e buscar gravetos no parque. Seus olhos atentos e focados se iluminam toda vez que alguém pega uma coleira, pronto para explorar o mundo ao seu lado. Thor é leal, protetor e um amigo para todas as horas.",

            "Ela ama carinhos na barriga e pode passar horas deitada ao seu lado, apenas aproveitando sua companhia. Mas não se engane! Quando ela " +
                    "vê uma trilha ou um espaço aberto, seu espírito aventureiro desperta. Ela é perfeita para quem busca um equilíbrio entre " +
                    "tranquilidade e diversão. Com ela, cada dia é uma nova oportunidade para explorar e se conectar.",


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
                petSex[i],
                petSize[i],
                puppyRace[i],
                petDescription[i],
            )

            puppyList.add(dataClass)
        }
        val adapter = PuppyAdapter(puppyList)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : PuppyAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {

                val intent = Intent(this@AdoptionFragment.requireContext(), DetailedDescription::class.java)
                intent.putExtra("petImage", puppyList[position].puppyImage)
                intent.putExtra("petName", puppyList[position].puppyName)
                intent.putExtra("petAge", puppyList[position].puppyAge)
                intent.putExtra("petSex", puppyList[position].puppySex)
                intent.putExtra("petRace", puppyList[position].puppyRace)
                intent.putExtra("petDescription", petDescription[position])

                startActivity(intent)
            }
        })
    }
}