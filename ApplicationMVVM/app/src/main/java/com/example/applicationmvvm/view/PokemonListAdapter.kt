package com.example.applicationmvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationmvvm.BR
import com.example.applicationmvvm.databinding.ListItemBinding
import com.example.applicationmvvm.model.json.Pokemon
import com.example.applicationmvvm.viewModel.PokemonListViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*

class PokemonListAdapter(private val pokemonListViewModel: PokemonListViewModel) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var pokemonList: List<Pokemon> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ListItemBinding.inflate(inflater, parent, false)
        return PokemonListViewHolder(dataBinding, pokemonListViewModel)
    }

    override fun getItemCount(): Int = pokemonList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PokemonListViewHolder) {
            return holder.bind(pokemonList[position])
        }
    }

    fun updatePokemonList(pokemonList: List<Pokemon>) {
        this.pokemonList = pokemonList
        notifyDataSetChanged()
    }

    inner class PokemonListViewHolder(
        private val dataBinding: ViewDataBinding,
        pokemonListViewModel: PokemonListViewModel
    ) : RecyclerView.ViewHolder(dataBinding.root) {

        private val pokemonPicture = itemView.pokemonPicture

        fun bind(itemData: Pokemon) {
            dataBinding.setVariable(BR.viewmodel, itemData)
            dataBinding.executePendingBindings()

            Picasso.get().load(itemData.img).into(pokemonPicture);
        }
    }
}