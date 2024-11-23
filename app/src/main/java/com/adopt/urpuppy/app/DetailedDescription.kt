package com.adopt.urpuppy.app

import android.content.Intent
import android.os.Bundle
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
    }

    private fun getPetDescriptionPage(){
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}