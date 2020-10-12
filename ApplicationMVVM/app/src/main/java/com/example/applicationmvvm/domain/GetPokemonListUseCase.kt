package com.example.applicationmvvm.domain

import androidx.lifecycle.LiveData
import com.example.applicationmvvm.model.json.Item

class GetPokemonListUseCase(private val pokemonListRepository: PokemonListRepository) {
    fun getPokemonList(): LiveData<List<Item>> {
        return pokemonListRepository.loadData()
    }
}