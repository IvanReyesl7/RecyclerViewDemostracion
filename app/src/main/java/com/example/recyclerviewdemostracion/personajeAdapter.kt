package com.example.recyclerviewdemostracion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class personajeAdapter(private val personajes: List<Personaje>) :
    RecyclerView.Adapter<personajeAdapter.PersonajeViewHolder>() {

    class PersonajeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.nombreTextView)
        val serieTextView: TextView = itemView.findViewById(R.id.serieTextView)
        val imagenImageView: ImageView = itemView.findViewById(R.id.imagenImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_personaje, parent, false)
        return PersonajeViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        val personaje = personajes[position]
        holder.nombreTextView.text = personaje.nombre
        holder.serieTextView.text = personaje.serie

        // Cargar imagen usando Glide
        Glide.with(holder.itemView.context)
            .load(personaje.imagen)
            .into(holder.imagenImageView)
    }

    override fun getItemCount(): Int = personajes.size
}
