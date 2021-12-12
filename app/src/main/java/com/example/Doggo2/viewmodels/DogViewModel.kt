package com.example.Doggo2.viewmodels

import androidx.lifecycle.*
import com.example.Doggo2.database.DogDao
import com.example.Doggo2.database.DogEntityClass
import com.example.Doggo2.network.DogApiResponse
import com.example.Doggo2.network.DogPhotoApi
import kotlinx.coroutines.launch

class DogViewModel(private val dogDao: DogDao) : ViewModel() {
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

    fun addDog(dogEntityClass: DogEntityClass) {
        viewModelScope.launch {
            dogDao.addPal(dogEntityClass)
        }

        fun getAllPals(): LiveData<List<DogEntityClass>> {
            return dogDao.getAll().asLiveData()
        }
    }

    class DogViewModelFactory(
        private val dogDao: DogDao
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DogViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return DogViewModel(dogDao) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }



}


