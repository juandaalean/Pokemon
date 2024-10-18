package com.example.pokemon.features.pokemons.domain

interface PokemonRepository {

    suspend fun getPokemons(): List<Pokemon>
    suspend fun getPokemon(pokemonId: String):Pokemon?
}