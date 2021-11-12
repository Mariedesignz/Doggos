package com.example.furrypal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import coil.load
import com.example.furrypal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    private lateinit var binding: ActivityMainBinding
    private val viewModel: DogViewModel by viewModels()

    fun getRandomDogPhoto() {
       val randomPhotoButton = binding.button
        viewModel.dogPhoto.observe(this, {
            val imgUri = it.imageUrl!!.toUri().buildUpon().scheme("https").build()
            binding.imageView.load(imgUri)
            randomPhotoButton.setOnClickListener{
                viewModel.getNewPhoto()
            }
        })
    }





}
