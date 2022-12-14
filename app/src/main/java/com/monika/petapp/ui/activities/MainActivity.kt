package com.monika.petapp.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.monika.petapp.databinding.ActivityMainBinding
import com.monika.petapp.ui.adapter.PetAdapter
import com.monika.petapp.ui.helper.OnClickListeners
import com.monika.petapp.ui.viewmodel.MainActivityViewModel
import com.monika.petapp.utils.WorkUtil

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MainActivity", "onCreate: " + viewModel.getWorkTime())
        val workingHours = viewModel.getWorkTime()
        if (!WorkUtil.isValidWorkingTime(workingHours)) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Pet shop is closed")
            builder.setMessage("Please come back in work hours $workingHours")
            builder.setPositiveButton("Ok") { _, _ ->
                finish()
            }
            builder.show()
        }

        val petAdapter = PetAdapter(object : OnClickListeners {
            override fun onClick(url: String) {
                val intent = Intent(this@MainActivity, DetailScreenActivity::class.java)
                intent.putExtra("url", url)
                startActivity(intent)
            }
        })

        binding.recyclerView.adapter = petAdapter

        viewModel.petList.observe(this) { petlist ->
            hideProgress()
            petlist.pets.let { pets ->
                petAdapter.petList = pets
                petAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun hideProgress() {
        binding.progressBar.visibility = View.GONE
        binding.recyclerView.visibility = View.VISIBLE
    }
}