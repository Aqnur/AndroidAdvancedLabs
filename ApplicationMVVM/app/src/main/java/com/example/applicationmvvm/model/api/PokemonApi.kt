package com.example.applicationmvvm.model.api

import com.example.applicationmvvm.model.json.PokemonResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {
    @GET("pokedex.json")
    fun getPokemonList() : Deferred<Response<PokemonResponse>>
}