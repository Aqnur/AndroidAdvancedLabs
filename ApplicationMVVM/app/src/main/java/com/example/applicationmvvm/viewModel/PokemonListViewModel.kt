package com.example.applicationmvvm.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.applicationmvvm.model.json.Pokemon
import com.example.applicationmvvm.model.repository.PokemonRepository

class PokemonListViewModel : BaseViewModel() {
    val pokemonListLive = MutableLiveData<List<Pokemon>>()

    fun getPokemonList() {
        dataLoading.value = true
        PokemonRepository.getInstance().getRepoList { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                pokemonListLive.value = response?.items
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}