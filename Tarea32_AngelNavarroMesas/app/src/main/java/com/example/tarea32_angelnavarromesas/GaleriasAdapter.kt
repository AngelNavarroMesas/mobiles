package com.example.tarea32_angelnavarromesas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tarea32_angelnavarromesas.databinding.ItemImagenBinding

class GaleriasAdapter (private val galeria: List<Imagen>) :
    RecyclerView.Adapter<GaleriasAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemImagenBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(galeria: Imagen) {
            Glide
                .with(binding.root.context)
                .load(galeria.urlFoto)
                .into(binding.Imagen)
        }
    }

    override fun getItemCount() = galeria.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding =
            ItemImagenBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(galeria[position])
    }

}