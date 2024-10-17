package com.example.pokemon.features.pokemons.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.app.extensions.loadUrl
import com.example.pokemon.databinding.ItemPokemonBinding
import com.example.pokemon.features.pokemons.domain.Pokemon

class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPokemonBinding.bind(view)

    fun render(pokemon: Pokemon){

        binding.apply {
            tvPokemonName.text = pokemon.name
            tvPokemonType.text = pokemon.type
            tvPokemonNumber.text = pokemon.pokedexNumber
            ivPokemon.loadUrl(pokemon.urlImage)

        }
    }
}