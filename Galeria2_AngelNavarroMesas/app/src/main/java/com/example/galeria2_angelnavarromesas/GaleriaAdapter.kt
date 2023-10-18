package com.example.galeria2_angelnavarromesas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
class GaleriaAdapter (private val imagen: List<Imagen>, private val onItemClick: (String) -> Unit) : RecyclerView.Adapter<GaleriaAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemCount() = imagen.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_imagen, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imagen = imagen[position]

        Glide.with(holder.itemView.context).load(imagen.urlFoto).into(holder.itemView.findViewById<ImageView>(R.id.Imagen))

        holder.itemView.setOnClickListener{
            onItemClick(imagen.urlFoto)
        }
    }
}