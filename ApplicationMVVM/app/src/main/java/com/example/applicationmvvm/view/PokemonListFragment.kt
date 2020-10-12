package com.example.applicationmvvm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applicationmvvm.databinding.PokemonsFragmentBinding
import com.example.applicationmvvm.viewModel.PokemonListViewModel
import kotlinx.android.synthetic.main.pokemons_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonListFragment : Fragment() {

    private lateinit var viewDataBinding: PokemonsFragmentBinding
    private lateinit var adapter: PokemonListAdapter
    private val pokemonListViewModel: PokemonListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewDataBinding = PokemonsFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        viewDataBinding.viewmodel = pokemonListViewModel
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.getPokemons()

        setupAdapter()
        setObservers()
    }

    private fun setObservers() {
        viewDataBinding.viewmodel?.getPokemons()?.observe(viewLifecycleOwner, Observer {
            adapter.updatePokemonList(it)
        })

//        viewDataBinding.viewmodel.toastMessage.observe(viewLifecycleOwner, Observer {
//            activity?.longToast(it)
//        })
    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = PokemonListAdapter(viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity)
            recycler_view.layoutManager = layoutManager
            recycler_view.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )
            recycler_view.adapter = adapter
        }
    }

}