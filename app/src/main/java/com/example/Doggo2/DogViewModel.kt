package com.example.Doggo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Doggo2.network.DogApiResponse
import com.example.Doggo2.network.DogPhotoApi
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {
    private val _dogPhoto = MutableLiveData<DogApiResponse>()
    val dogPhoto: LiveData<DogApiResponse> = _dogPhoto

    init {
        getNewPhoto()
    }

    fun getNewPhoto() {

        viewModelScope.launch {
            _dogPhoto.value = DogPhotoApi.retrofitService.getRandomPhoto()
        }
    }
}

