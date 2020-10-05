package com.example.applicationmvvm.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.applicationmvvm.model.json.Item
import com.example.applicationmvvm.model.repository.PokemonRepository

class PokemonListViewModel(private val pokemonRepository: PokemonRepository) : BaseViewModel() {

    val pokemonListLive = MutableLiveData<List<Item>>()

    fun getPokemons() {
        dataLoading.value = true
        pokemonRepository.getPokemonList { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                pokemonListLive.value = response?.pokemon
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }


}