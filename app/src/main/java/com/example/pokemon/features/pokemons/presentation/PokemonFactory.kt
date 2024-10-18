package com.example.pokemon.features.pokemons.presentation

import android.content.Context
import com.example.pokemon.app.data.api.ApiClient
import com.example.pokemon.features.pokemons.data.PokemonDataRepository
import com.example.pokemon.features.pokemons.data.local.PokemonXmlLocalDataSource
import com.example.pokemon.features.pokemons.data.remote.PokemonApiRemoteDataSource
import com.example.pokemon.features.pokemons.data.remote.PokemonMockRemoteDataSource
import com.example.pokemon.features.pokemons.domain.GetPokemonUseCase
import com.example.pokemon.features.pokemons.domain.GetPokemonsUseCase

class PokemonFactory(private val context: Context) {

    private val pokemonMockRemote =  PokemonMockRemoteDataSource()

    private val pokemonLocal = PokemonXmlLocalDataSource(context)

    private val pokemonDataRepository = PokemonDataRepository(pokemonLocal, getPokemonApiDataSource())

    private val getPokemonUseCase = GetPokemonUseCase(pokemonDataRepository)
    private val getPokemonsUseCase = GetPokemonsUseCase(pokemonDataRepository)

    fun buildViewModel(): PokemonViewModel{
        return PokemonViewModel(getPokemonsUseCase)
    }

    fun buildPokemonDetailViewModel(): PokemonDetailViewModel{
        return PokemonDetailViewModel(getPokemonUseCase)
    }

    private fun getPokemonApiDataSource():PokemonApiRemoteDataSource{
        val pokemonService = ApiClient.providePokemonService()
        return PokemonApiRemoteDataSource(pokemonService)
    }
}