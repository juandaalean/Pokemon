package com.example.pokemon.features.pokemons.data.remote

import com.example.pokemon.features.pokemons.domain.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("all.json")
    suspend fun requestPokemon(): Response<List<Pokemon>>

    @GET("id/pokemonId.json")
    suspend fun requestPokemon(@Path("pokemonId")pokemonId: String): Response<Pokemon>
}