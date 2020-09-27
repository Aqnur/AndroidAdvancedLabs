package com.example.applicationmvvm.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.applicationmvvm.R
import com.example.applicationmvvm.model.json.Pokemon
import com.example.applicationmvvm.viewModel.PokemonViewModel

class PokemonListAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var pokemonList: List<Pokemon> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return PokemonListViewHolder(inflater)
    }

    override fun getItemCount(): Int = pokemonList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PokemonListViewHolder) {
            return holder.bind(pokemonList[position])
        }
    }

    fun updateRepoList(repoList: List<Pokemon>) {
        this.pokemonList = repoList
        notifyDataSetChanged()
    }

    fun clearAll() {
        (pokemonList as? ArrayList<Pokemon>)?.clear()
        notifyDataSetChanged()
    }

    inner class PokemonListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val pokemonPicture: ImageView = itemView.findViewById(R.id.pokemonPicture)
        private val pokemonName: TextView = itemView.findViewById(R.id.pokemonName)

        fun bind(pokemon: Pokemon) {
            Glide.with(itemView.context)
                .load(pokemon.img)
                .into(pokemonPicture)

            pokemonName.text = pokemon.name
        }
    }
}