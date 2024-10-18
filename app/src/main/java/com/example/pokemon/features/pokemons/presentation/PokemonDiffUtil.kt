package com.example.pokemon.features.pokemons.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.pokemon.features.pokemons.domain.Pokemon

class PokemonDiffUtil : DiffUtil.ItemCallback<Pokemon>() {
    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem == newItem
    }
}