package com.example.applicationmvvm.model.repository

import com.example.applicationmvvm.model.api.PokemonApi
import com.example.applicationmvvm.model.api.RetrofitService
import com.example.applicationmvvm.model.json.Pokemon
import com.example.applicationmvvm.model.json.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepository {

    // GET repo list
    fun getRepoList(onResult: (isSuccess: Boolean, response: PokemonResponse?) -> Unit) {

        RetrofitService.getPokemonsApi(PokemonApi::class.java).getPokemonList().enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(call: Call<PokemonResponse>?, response: Response<PokemonResponse>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<PokemonResponse>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }

    companion object {
        private var INSTANCE: PokemonRepository? = null
        fun getInstance() = INSTANCE
            ?: PokemonRepository().also {
                INSTANCE = it
            }
    }
}