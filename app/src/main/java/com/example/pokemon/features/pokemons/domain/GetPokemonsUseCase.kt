package com.example.pokemon.features.pokemons.domain

class GetPokemonsUseCase(private val pokemonRepository: PokemonRepository) {

    suspend operator fun invoke():List<Pokemon>{
        return pokemonRepository.getPokemons()
    }
}