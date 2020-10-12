package com.example.applicationmvvm.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.applicationmvvm.model.api.PokemonApi
import com.example.applicationmvvm.model.json.Item
import com.example.applicationmvvm.model.json.PokemonResponse
import kotlinx.coroutines.*
import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber

abstract class BaseDataStore(@PublishedApi internal val service: PokemonApi) {

    abstract fun loadData(): LiveData<List<Item>>

    inline fun fetchData(crossinline call: (PokemonApi) -> Deferred<Response<PokemonResponse>>): LiveData<List<Item>> {
        val result = MutableLiveData<List<Item>>()
        CoroutineScope(Dispatchers.IO).launch {
            val request = call(service)
            withContext(Dispatchers.Main) {
                try {
                    val response = request.await()
                    if (response.isSuccessful) {
                        result.value = response.body()?.pokemon
                    } else {
                        Timber.d("Error occurred with code ${response.code()}")
                    }
                } catch (e: HttpException) {
                    Timber.d("Error: ${e.message()}")
                } catch (e: Throwable) {
                    Timber.d("Error: ${e.message}")
                }
            }
        }

        return result
    }

}