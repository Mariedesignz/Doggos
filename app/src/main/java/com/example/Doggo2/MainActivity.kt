package com.example.Doggo2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import coil.load
import com.example.Doggo2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val viewModel: DogViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        viewModel.dogPhoto.observe(this,
            {
                findViewById<ImageView>(R.id.imageView).load(it.message?.toUri()?.buildUpon()?.scheme("https")?.build()
                )

            })
    findViewById<Button>(R.id.button).setOnClickListener {
        viewModel.getNewPhoto() }
    }


}
