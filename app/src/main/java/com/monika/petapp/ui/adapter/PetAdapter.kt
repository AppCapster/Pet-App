package com.monika.petapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.monika.petapp.R
import com.monika.petapp.databinding.PetItemBinding
import com.monika.petapp.model.Pet
import com.monika.petapp.ui.helper.OnClickListeners

class PetAdapter(private val onClickListeners: OnClickListeners) :
    RecyclerView.Adapter<PetAdapter.PetViewHolder>() {

    var petList: List<Pet> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        return PetViewHolder(parent)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.bind(petList[position])
    }

    override fun getItemCount() = petList.size

    inner class PetViewHolder(
        private val parent: ViewGroup,
        private val binding: PetItemBinding = PetItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pet: Pet) {
            binding.tvTitle.text = pet.title
            binding.petCard.setOnClickListener {
                onClickListeners.onClick(pet.contentUrl)
            }
            Glide
                .with(parent.context)
                .load(pet.imageUrl)
                .placeholder(R.drawable.ic_baseline_image_24)
                .into(binding.petImage)
        }
    }

}
