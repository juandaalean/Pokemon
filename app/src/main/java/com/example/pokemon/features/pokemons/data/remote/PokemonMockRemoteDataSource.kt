package com.example.pokemon.features.pokemons.data.remote

import com.example.pokemon.features.pokemons.domain.Pokemon

class PokemonMockRemoteDataSource {

    private val pokemons = listOf(
        Pokemon(
            "1",
            "Flareon",
            "Fire",
            "136",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/136.png"
        ),
        Pokemon(
            "2",
            "Mew",
            "Psychic",
            "151",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/151.png"
        ),
        Pokemon(
            "3",
            "Scorbunny",
            "Fire",
            "813",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/813.png"
        ),
        Pokemon(
            "4",
            "Umbreon",
            "Dark",
            "197",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/197.png"
        ),
        Pokemon(
            "5",
            "Jillicent",
            "Water",
            "521",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/593.png"
        ),
        Pokemon(
            "6",
            "Pikachu",
            "Electro",
            "25",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/025.png"
        )
        )


    fun getPokemons(): List<Pokemon>{
        return pokemons
    }

    fun getPokemon(pokemonId: String): Pokemon?{
        return pokemons.firstOrNull(){ pokemon ->
            pokemon.id == pokemonId
        }
    }
}