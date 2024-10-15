package com.example.pokemon.features.pokemons.data.local

import android.content.Context
import com.example.pokemon.R
import com.example.pokemon.features.pokemons.domain.Pokemon
import com.google.gson.Gson

class PokemonXmlLocalDataSource(private val context: Context) {

    private val sharedPref =context.getSharedPreferences(
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun save(pokemon: Pokemon){
        val editor = sharedPref.edit()
        editor.putString(pokemon.id, gson.toJson(pokemon))
        editor.apply()
    }

    fun saveAll(pokemons: List<Pokemon>){
        val editor = sharedPref.edit()
        pokemons.forEach{ pokemon ->
            editor.putString(pokemon.id, gson.toJson(pokemon))
        }
        editor.apply()
    }

    fun findAll(): List<Pokemon>{
        val pokemons = ArrayList<Pokemon>()
        val mapPokemon = sharedPref.all
        mapPokemon.values.forEach { jsonPokemon ->
            val pokemon = gson.fromJson(jsonPokemon as String, Pokemon::class.java)
            pokemons.add(pokemon)
        }
        return pokemons
    }

    fun findById(pokemonId: String): Pokemon?{
        return sharedPref.getString(pokemonId, null)?.let { pokemon ->
            gson.fromJson(pokemon, Pokemon::class.java)
        }
    }
}