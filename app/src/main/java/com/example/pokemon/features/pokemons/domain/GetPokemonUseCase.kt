package com.example.pokemon.features.pokemons.domain

class GetPokemonUseCase(private val pokemonRepository: PokemonRepository) {

    operator fun invoke(pokemonId: String): Pokemon?{
        return pokemonRepository.getPokemon(pokemonId)
    }
}