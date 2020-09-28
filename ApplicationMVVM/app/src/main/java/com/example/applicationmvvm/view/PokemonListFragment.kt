package com.example.applicationmvvm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applicationmvvm.R
import com.example.applicationmvvm.databinding.MainNavFragmentBinding
import com.example.applicationmvvm.viewModel.PokemonListViewModel
import kotlinx.android.synthetic.main.main_nav_fragment.*

class PokemonListFragment : Fragment() {

    private lateinit var viewDataBinding: MainNavFragmentBinding
    private lateinit var adapter: PokemonListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = MainNavFragmentBinding.inflate(inflater, container, false).apply {
            viewmodel =
                ViewModelProviders.of(this@PokemonListFragment).get(PokemonListViewModel::class.java)
            lifecycleOwner = viewLifecycleOwner
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        setObservers()
    }

    private fun setObservers() {
        viewDataBinding.viewmodel?.pokemonListLive?.observe(viewLifecycleOwner, Observer {
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
            recyclerView.layoutManager = layoutManager
            recyclerView.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )
            recyclerView.adapter = adapter
        }
    }

}