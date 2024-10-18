package com.example.pokemon.features.pokemons.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.app.domain.ErrorApp
import com.example.pokemon.features.pokemons.domain.GetPokemonsUseCase
import com.example.pokemon.features.pokemons.domain.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PokemonViewModel(private val getPokemonsUseCase: GetPokemonsUseCase): ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun viewCreated() {
        viewModelScope.launch(Dispatchers.IO) {
            val pokemons = getPokemonsUseCase.invoke()
            _uiState.postValue(UiState(pokemons = pokemons))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val pokemons: List<Pokemon>? = null
    )
}




