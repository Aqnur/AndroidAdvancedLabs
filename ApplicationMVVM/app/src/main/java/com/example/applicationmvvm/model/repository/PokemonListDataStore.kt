package com.example.applicationmvvm.model.repository

import androidx.lifecycle.LiveData
import com.example.applicationmvvm.domain.PokemonListRepository
import com.example.applicationmvvm.model.api.PokemonApi
import com.example.applicationmvvm.model.json.Item

class PokemonListDataStore(apiService: PokemonApi) : PokemonListRepository, BaseDataStore(apiService) {

    override fun loadData(): LiveData<List<Item>> {
        return fetchData { service.getPokemonList() }
    }

}