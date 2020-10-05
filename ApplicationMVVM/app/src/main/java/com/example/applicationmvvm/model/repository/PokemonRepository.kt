package com.example.applicationmvvm.model.repository

import android.util.Log
import com.example.applicationmvvm.model.api.RetrofitService
import com.example.applicationmvvm.model.json.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepository {

    fun getPokemonList(onResult: (isSuccess: Boolean, response: PokemonResponse?) -> Unit) {

        RetrofitService.getPostApi().getPokemonList().enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(
                call: Call<PokemonResponse>?,
                response: Response<PokemonResponse>?
            ) {
                if (response != null && response.isSuccessful) {
                    onResult(true, response.body())
                    Log.d("RepositoryResult", response.body().toString())
                    Log.d("RepositoryIsSucc", response.isSuccessful.toString())
                } else {
                    onResult(false, null)
                    Log.d("RepositoryIsSucc", response!!.isSuccessful.toString())
                }
            }

            override fun onFailure(call: Call<PokemonResponse>?, t: Throwable?) {
                onResult(false, null)
                Log.d("repoError", t?.printStackTrace().toString())
                Log.d("repoError", t?.message.toString())
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