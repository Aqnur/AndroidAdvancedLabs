package com.example.applicationmvvm.domain

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.applicationmvvm.model.api.PokemonApi
import com.example.applicationmvvm.model.api.RetrofitService
import com.example.applicationmvvm.model.json.Item
import com.example.applicationmvvm.model.json.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface PokemonListRepository {
    fun loadData(): LiveData<List<Item>>
}