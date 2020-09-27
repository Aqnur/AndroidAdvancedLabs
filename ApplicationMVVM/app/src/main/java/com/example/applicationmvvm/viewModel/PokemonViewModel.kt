package com.example.applicationmvvm.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.applicationmvvm.model.json.Pokemon
import com.example.applicationmvvm.model.repository.PokemonRepository

class PokemonViewModel(private var pokemonRepository: PokemonRepository) : BaseViewModel() {

    val liveData = MutableLiveData<State>()

    fun showPokemonList() {
        liveData.value = State.ShowLoading
        pokemonRepository.getPokemonList { isSuccess, response ->
            liveData.value = State.HideLoading
            if (isSuccess) {
                liveData.value = State.Result(response)
                Log.d("RESULT", response.toString())
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }

    sealed class State {
        object ShowLoading : State()
        object HideLoading : State()
        data class Result(val list: List<Pokemon>?) : State()
    }
}