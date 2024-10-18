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
            "Cinccino",
            "Normal",
            "573",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/573.png"
        ),
        Pokemon(
            "6",
            "Pichu",
            "Electro",
            "172",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/172.png"
        ),
        Pokemon(
            "7",
            "Mightyena",
            "Dark",
            "262",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/262.png"
        ),
        Pokemon(
            "8",
            "Charizard",
            "Fire",
            "6",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/006.png"
        ),
        Pokemon(
            "9",
            "Ditto",
            "Normal",
            "132",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/132.png"
        ),
        Pokemon(
            "10",
            "Persian",
            "Normal",
            "53",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/053.png"
        ),
        Pokemon(
            "11",
            "Timburr",
            "Fighter",
            "532",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/532.png"
        ),
        Pokemon(
            "12",
            "Tangela",
            "Plant",
            "114",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/114.png"
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