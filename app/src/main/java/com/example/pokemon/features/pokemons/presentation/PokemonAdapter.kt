package com.example.pokemon.features.pokemons.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.R
import com.example.pokemon.features.pokemons.domain.Pokemon

class PokemonAdapter() : ListAdapter<Pokemon, PokemonViewHolder>(PokemonDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PokemonViewHolder(layoutInflater.inflate(R.layout.item_pokemon, parent, false))
    }

    override fun getItemCount(): Int = currentList.size


    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item =currentList[position]
        holder.render(item)
    }
}