package com.example.applicationmvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationmvvm.databinding.PokemonListItemBinding
import com.example.applicationmvvm.model.json.Item
import com.example.applicationmvvm.viewModel.PokemonListViewModel

class PokemonListAdapter(private val pokemonListViewModel: PokemonListViewModel) :
    RecyclerView.Adapter<PokemonListViewHolder>() {

    private var pokemonList: List<Item> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = PokemonListItemBinding.inflate(inflater, parent, false)
        return PokemonListViewHolder(dataBinding, pokemonListViewModel)
    }

    override fun getItemCount(): Int = pokemonList.size

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        holder.bind(pokemonList[position])
    }

    fun updatePokemonList(pokemonList: List<Item>) {
        this.pokemonList = pokemonList
        notifyDataSetChanged()
    }
}