package com.example.pokemon.features.pokemons.domain

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("types") val type: String,
    @SerializedName("order") val pokedexNumber: String,
    @SerializedName("sprites.front_default") val urlImage: String
)