package com.example.Doggo2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.Doggo2.viewmodels.DogApplication
import com.example.Doggo2.viewmodels.DogViewModel
import com.squareup.picasso.Picasso


class MainActivity2 : AppCompatActivity() {

        private val viewModel: DogViewModel by viewModels{
            DogViewModel.DogViewModelFactory((application as DogApplication).database.dogDao())
        }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.secondscreen)

            viewModel.getAllPals().observe(this){

                val count = it.size


              val imageView = findViewById<ImageView>(R.id.newView)
                Picasso.with(this).load(it[count -1].imageUrl).into(imageView)

            findViewById<Button>(R.id.Return).setOnClickListener {
                finish()
            }
                    }
            }

        }
