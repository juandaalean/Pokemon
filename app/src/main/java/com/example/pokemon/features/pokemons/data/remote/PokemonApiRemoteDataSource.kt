package com.example.pokemon.features.pokemons.data.remote

import com.example.pokemon.features.pokemons.domain.Pokemon

class PokemonApiRemoteDataSource(private val pokemonService: PokemonService) {

    suspend fun getPokemons(): List<Pokemon>{
        val response = pokemonService.requestPokemon()
        if (response.isSuccessful){
            return response.body()!!
        } else{
            //error
            return emptyList()
        }
    }

    suspend fun getPokemon(pokemonId: String): Pokemon?{
        val response = pokemonService.requestPokemon(pokemonId)
        if (response.isSuccessful){
            return response.body()!!
        } else{}
            return Pokemon("Error", "Error", "Error", "Error", "Error")
    }
}