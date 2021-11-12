package com.example.furrypal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.furrypal.network.DogPhotoApi
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {
    private val _dogPhoto = MutableLiveData<DogPhotoApi>()
    val dogPhoto: LiveData<DogPhotoApi> = _dogPhoto

    init {
        getNewPhoto()
    }

    fun getNewPhoto() {

        viewModelScope.launch {
            _dogPhoto.value = DogPhotoApi.retrofitService.getRandomPhoto()
        }
    }
}

