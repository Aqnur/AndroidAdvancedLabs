package com.example.applicationmvvm.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.applicationmvvm.model.json.Item
import com.example.applicationmvvm.model.repository.PokemonRepository

class PokemonListViewModel : BaseViewModel() {
    val pokemonListLive = MutableLiveData<List<Item>>()

    fun getPokemons() {
        dataLoading.value = true
        PokemonRepository.getInstance().getPokemonList { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                pokemonListLive.value = response?.pokemon
                Log.d("VMresponse", response?.pokemon.toString())
                Log.d("VMSUCCESS", "SUCCESS")
                empty.value = false
            } else {
                empty.value = true
                Log.d("VMSUCCESS", "NOT SUCCESS")
                Log.d("VMresponse", response?.pokemon.toString())
            }
        }
    }
}