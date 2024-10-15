package com.example.pokemon.features.pokemons.domain

interface PokemonRepository {

    fun getPokemons(): List<Pokemon>
    fun getPokemon(pokemonId: String):Pokemon?
}