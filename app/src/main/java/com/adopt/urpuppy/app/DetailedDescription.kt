package com.adopt.urpuppy.app

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.adopt.urpuppy.databinding.ActivityPetDescriptionBinding

class DetailedDescription : AppCompatActivity() {
    private lateinit var binding: ActivityPetDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPetDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val petImage: ImageView = binding.petPerfil
        val petImageBg: ImageView = binding.descPerfilBg


        val bundle: Bundle? = intent.extras
        val image = bundle!!.getInt("petImage")
        val name = bundle.getString("petName")
        val sex = bundle.getString("petSex")
        val age = bundle.getString("petAge")
        val race = bundle.getString("petRace")
        val desc = bundle.getString("petDescription")

        petImage.setImageResource(image)
        petImage.scaleType = ImageView.ScaleType.CENTER_CROP
        petImageBg.setImageResource(image )
        binding.descPetName.text = name
        binding.petRace.text = race
        binding.petSex.text = sex
        binding.petAge.text = age
        binding.petDescription.text = desc


        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

}