package com.example.pokemon.features.pokemons.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.databinding.FragmentPokemonBinding

class PokemonsFragment : Fragment() {


    private var _binding: FragmentPokemonBinding? = null
    private val binding get() = _binding!!

    private lateinit var pokemonFactory: PokemonFactory
    private lateinit var viewModel: PokemonViewModel

    private val pokemonAdapter = PokemonAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonFactory = PokemonFactory(requireContext())
        viewModel = pokemonFactory.buildViewModel()
        viewModel.viewCreated()
        setupObserver()
    }

    private fun setupObserver() {
        val pokemonObserver = Observer<PokemonViewModel.UiState> { uiState ->
            uiState.pokemons?.let {
                pokemonAdapter.submitList(it)
            }
            uiState.errorApp?.let {

            }
            if (uiState.isLoading) {

            } else {

            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, pokemonObserver)
    }


    private fun setupView() {
        binding.apply {
            pokemonRecyclerView.layoutManager = LinearLayoutManager(
                requireContext(), RecyclerView.VERTICAL,
                false
            )
            pokemonRecyclerView.adapter = pokemonAdapter

        }
    }


    private fun navegationToDetails(pokemonId: String) {
        findNavController().navigate(
            PokemonsFragmentDirections.actionFromPokemonToPokemonDetail(
                pokemonId
            )
        )
    }
}