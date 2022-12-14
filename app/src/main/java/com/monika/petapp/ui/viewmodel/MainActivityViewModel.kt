package com.monika.petapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.monika.petapp.model.PetList
import com.monika.petapp.repository.PetRepository
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val petRepository = PetRepository(application)
    val petList: MutableLiveData<PetList> = MutableLiveData()

    init {
        getPetList()
    }

    private fun getPetList() = viewModelScope.launch {
        petList.value = petRepository.getPetListData()
    }

    fun getWorkTime(): String {
        return petRepository.getWorkTime()
    }
}