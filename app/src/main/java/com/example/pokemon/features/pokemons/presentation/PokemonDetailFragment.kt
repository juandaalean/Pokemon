package com.example.pokemon.features.pokemons.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.pokemon.app.extensions.loadUrl
import com.example.pokemon.databinding.FragmentPokemonDetailBinding
import com.example.pokemon.features.pokemons.domain.Pokemon

class PokemonDetailFragment: Fragment() {

    private lateinit var pokemonFactory: PokemonFactory
    private lateinit var viewModel: PokemonDetailViewModel

    private var _binding: FragmentPokemonDetailBinding? = null
    private val binding get() = _binding!!

    private val pokemonArgs: PokemonDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonFactory = PokemonFactory(requireContext())
        viewModel = pokemonFactory.buildPokemonDetailViewModel()
        setupObserver()
        pokemonArgs.pokemonId?.let {
            viewModel.viewCreated(it)
        }
    }


    private fun setupObserver(){
        val pokemonObserver = Observer<PokemonDetailViewModel.UiState>{uiState ->
            uiState.pokemon?.let {
                bindData(it)
            }
            uiState.errorApp?.let {

            }
            if (uiState.isLoading){

            } else{

            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, pokemonObserver)
    }

    private fun bindData(pokemon: Pokemon) {
        binding.apply {
            pokeimg1.loadUrl(pokemon.urlImage)
            pokename1.text = pokemon.name
            poketype1.text = pokemon.type
            pokenumber1.text = pokemon.pokedexNumber
        }
    }
}