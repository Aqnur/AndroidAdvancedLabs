package com.example.applicationmvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.applicationmvvm.domain.GetPokemonListUseCase
import com.example.applicationmvvm.model.json.Item
import com.example.applicationmvvm.domain.PokemonListRepository

class PokemonListViewModel(private val getPokemonListUseCase: GetPokemonListUseCase) : BaseViewModel() {

    fun getPokemons(): LiveData<List<Item>> {
        return getPokemonListUseCase.getPokemonList()
    }

}