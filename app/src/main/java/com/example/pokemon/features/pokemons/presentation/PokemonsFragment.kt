package com.example.pokemon.features.pokemons.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.pokemon.app.extensions.loadUrl
import com.example.pokemon.databinding.FragmentPokemonBinding
import com.example.pokemon.features.pokemons.domain.Pokemon

class PokemonsFragment : Fragment() {

    private lateinit var pokemonFactory: PokemonFactory
    private lateinit var viewModel: PokemonViewModel

    private var _binding: FragmentPokemonBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokemonFactory = PokemonFactory(requireContext())
        viewModel = pokemonFactory.buildViewModel()
        setupObserver()
        viewModel.viewCreated()
    }

    private fun setupObserver(){
        val pokemonObserver = Observer<PokemonViewModel.UiState>{uiState ->
            uiState.pokemons?.let {
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

    private fun bindData(pokemons: List<Pokemon>){
        binding.apply {
            pokemon1.apply {
                text = pokemons[0].name
                setOnClickListener {
                    navegationToDetails(pokemons[0].id)
                }
            }
            pokebackground1.loadUrl(pokemons[0].urlImage)

            pokemon2.apply {
                text = pokemons[1].name
                setOnClickListener {
                    navegationToDetails(pokemons[1].id)
                }
            }
            pokebackground2.loadUrl(pokemons[1].urlImage)

            pokemon3.apply {
                text = pokemons[2].name
                setOnClickListener {
                    navegationToDetails(pokemons[2].id)
                }
            }
            pokebackground3.loadUrl(pokemons[2].urlImage)

            pokemon4.apply {
                text = pokemons[3].name
                setOnClickListener {
                    navegationToDetails(pokemons[3].id)
                }
            }
            pokebackground4.loadUrl(pokemons[3].urlImage)


        }
    }

    private fun navegationToDetails(pokemonId: String){
            findNavController().navigate(PokemonsFragmentDirections.actionFromPokemonToPokemonDetail(pokemonId))
    }
}