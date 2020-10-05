package com.example.applicationmvvm.view

import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.applicationmvvm.BR
import com.example.applicationmvvm.model.json.Item
import com.example.applicationmvvm.viewModel.PokemonListViewModel
import kotlinx.android.synthetic.main.pokemon_list_item.view.*

class PokemonListViewHolder constructor(
    private val dataBinding: ViewDataBinding,
    pokemonListViewModel: PokemonListViewModel
) : RecyclerView.ViewHolder(dataBinding.root) {

    private val pokemonPicture = itemView.pokemonPicture

    fun bind(itemData: Item) {
        var img = "https://" + itemData.img.substring(7)
        Glide.with(itemView.context)
            .load(img)
            .into(pokemonPicture)

        Log.d("images", img)
        dataBinding.setVariable(BR.pokemonData, itemData)
        dataBinding.executePendingBindings()
    }
}