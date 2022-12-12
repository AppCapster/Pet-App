package com.monika.petapp.repository.helper

import android.app.Application
import com.google.gson.Gson
import com.monika.petapp.R
import com.monika.petapp.model.PetList
import com.monika.petapp.model.WorkTimeList
import org.json.JSONObject

/*
*  @PetRepoHelper class help's to fetch required data
* */
class PetRepoHelper(private val application: Application) {

    private val gson = Gson()

    // Returns list of Pet from pets_list.json
    fun getPetList(): PetList {
        val response = application.resources.openRawResource(R.raw.pets_list)
            .bufferedReader().use { it.readText() }
        return gson.fromJson(response, PetList::class.java)
    }

    // Returns Work Time parsing from config.json
    fun getWorkTime(): String {
        val response = application.resources.openRawResource(R.raw.config)
            .bufferedReader().use { it.readText() }
        val jsonObject = JSONObject(response.substringAfter(" "))
        return jsonObject.getString("workHours")
    }
}