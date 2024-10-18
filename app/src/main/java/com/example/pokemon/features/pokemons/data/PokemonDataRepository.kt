package com.example.pokemon.features.pokemons.data

import com.example.pokemon.features.pokemons.data.local.PokemonXmlLocalDataSource
import com.example.pokemon.features.pokemons.data.remote.PokemonApiRemoteDataSource
import com.example.pokemon.features.pokemons.data.remote.PokemonMockRemoteDataSource
import com.example.pokemon.features.pokemons.domain.Pokemon
import com.example.pokemon.features.pokemons.domain.PokemonRepository

class PokemonDataRepository(
    private val local: PokemonXmlLocalDataSource,
    private val remote: PokemonApiRemoteDataSource
) : PokemonRepository {

    override suspend fun getPokemons(): List<Pokemon> {
        val pokemonFromLocal = local.findAll()
        if (pokemonFromLocal.isEmpty()) {
            val pokemonFromRemote = remote.getPokemons()
            local.saveAll(pokemonFromRemote)
            return pokemonFromRemote
        }
        return pokemonFromLocal
    }

        override suspend fun getPokemon(pokemonId: String): Pokemon? {
        val localPokemon = local.findById(pokemonId)
        if (localPokemon == null){
            remote.getPokemon(pokemonId)?.let {
                local.save(it)
                return it
            }
        }
        return localPokemon
    }
}