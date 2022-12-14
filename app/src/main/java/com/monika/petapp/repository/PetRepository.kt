package com.monika.petapp.repository

import android.app.Application
import com.monika.petapp.model.PetList
import com.monika.petapp.repository.helper.PetRepoHelper

class PetRepository(application: Application) {

    private val petRepoHelper = PetRepoHelper(application)

    fun getPetListData(): PetList {
        return petRepoHelper.getPetList()
    }

    fun getWorkTime(): String {
        return petRepoHelper.getWorkTime()
    }
}