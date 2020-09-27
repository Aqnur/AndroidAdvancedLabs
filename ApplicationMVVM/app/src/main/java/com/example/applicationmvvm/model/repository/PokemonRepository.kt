package com.example.applicationmvvm.model.repository

import com.example.applicationmvvm.model.api.PokemonApi
import com.example.applicationmvvm.model.api.RetrofitService
import com.example.applicationmvvm.model.json.Pokemon
import com.example.applicationmvvm.model.json.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface PokemonRepository {
    fun getPokemonList(onResult: (isSuccess: Boolean, response: List<Pokemon>?) -> Unit)
}

class PokemonRepositoryImpl(private val retrofitService: RetrofitService) : PokemonRepository {

    override fun getPokemonList(onResult: (isSuccess: Boolean, response: List<Pokemon>?) -> Unit) {

        retrofitService.getPokemonsApi(PokemonApi::class.java).getPokemonList().enqueue(object : Callback<List<Pokemon>> {
            override fun onResponse(call: Call<List<Pokemon>>?, response: Response<List<Pokemon>>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<List<Pokemon>>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }

}