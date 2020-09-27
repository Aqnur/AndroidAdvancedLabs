package com.example.applicationmvvm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.applicationmvvm.R
import com.example.applicationmvvm.model.api.RetrofitService
import com.example.applicationmvvm.model.repository.PokemonRepository
import com.example.applicationmvvm.model.repository.PokemonRepositoryImpl
import com.example.applicationmvvm.viewModel.PokemonViewModel

class PokemonListFragment : Fragment() {

//    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private var adapter: PokemonListAdapter? = null
    private lateinit var pokemonViewModel: PokemonViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_nav_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews(view)
        adapter()
//        swipeRefresh()
        getPokemonList()
    }

    private fun bindViews(view: View) {
//        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout)
        recyclerView = view.findViewById(R.id.recyclerView)
    }

    private fun adapter() {
        layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.layoutManager = layoutManager
        adapter = PokemonListAdapter(this.requireContext())
        recyclerView.adapter = adapter
    }

//    private fun swipeRefresh() {
//        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
//        swipeRefreshLayout.setOnRefreshListener {
//            adapter?.clearAll()
//            pokemonViewModel?.showPokemonList()
//        }
//    }

    private fun getPokemonList() {
        val pokemonRepository: PokemonRepository = PokemonRepositoryImpl(RetrofitService)
        pokemonViewModel = PokemonViewModel(pokemonRepository)

        pokemonViewModel?.showPokemonList()
        pokemonViewModel?.liveData?.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is PokemonViewModel.State.ShowLoading -> {
//                    swipeRefreshLayout.isRefreshing = true
                }
                is PokemonViewModel.State.HideLoading -> {
//                    swipeRefreshLayout.isRefreshing = false
                }
                is PokemonViewModel.State.Result -> {
                    adapter?.updateRepoList(result.list!!)
                }
            }
        })
    }
}