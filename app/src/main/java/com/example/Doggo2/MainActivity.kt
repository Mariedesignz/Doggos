package com.example.Doggo2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import coil.load
import com.example.Doggo2.database.DogEntityClass
import com.example.Doggo2.viewmodels.DogApplication



class MainActivity : AppCompatActivity() {

    private val viewModel: DogViewModel by viewModels{
        DogViewModel.DogViewModelFactory((application as DogApplication).database.dogDao())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        viewModel.dogPhoto.observe(this,
            {
                findViewById<ImageView>(R.id.imageView).load(it.message?.toUri()?.buildUpon()?.scheme("https")?.build()
                )

            })

        findViewById<Button>(R.id.button).setOnClickListener {
        viewModel.getNewPhoto()
         }
        val currentImgUrl = viewModel.dogPhoto.value?.message
        val newDogImage = currentImgUrl?.let { it1 ->
            DogEntityClass(imageUrl = it1) }
        if (newDogImage != null) {
            viewModel.addDog(newDogImage)
        }
        findViewById<Button>(R.id.back).setOnClickListener{
            val intent = Intent( this,MainActivity2::class.java)
            startActivity(intent)
        }
    }




}
