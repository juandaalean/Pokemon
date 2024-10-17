package com.example.pokemon.features.pokemons.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.app.extensions.loadUrl
import com.example.pokemon.databinding.ItemPokemonBinding
import com.example.pokemon.features.pokemons.domain.Pokemon

class PokemonViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding: ItemPokemonBinding

    fun render(pokemon: Pokemon){
        binding = ItemPokemonBinding.bind(view)
        binding.apply {
            tvPokemonName.text = "Nombre: " + pokemon.name
            tvPokemonType.text = "Tipo: " + pokemon.type
            tvPokemonNumber.text = "Numero de Pokedex: " + pokemon.pokedexNumber
            ivPokemon.loadUrl(pokemon.urlImage)

        }
    }
}