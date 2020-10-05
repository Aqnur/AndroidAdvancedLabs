package com.example.applicationmvvm.di

import android.content.SharedPreferences
import com.example.applicationmvvm.model.api.PokemonApi
import com.example.applicationmvvm.model.api.RetrofitService
import com.example.applicationmvvm.model.api.RetrofitService.getPostApi
import com.example.applicationmvvm.model.repository.PokemonRepository
import com.example.applicationmvvm.viewModel.PokemonListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PokemonListViewModel(pokemonRepository = get()) }
}

val repositoryModule = module {
    single { PokemonRepository(apiService = get()) }
}

val networkModule = module {
    single { getPostApi() }
//    single { getOkHttpClient(authInterceptor = get()) }
//    single { getAuthInterceptor(sharedPreferences = get()) }
}


val sharedPrefModule = module {
    single {
        androidApplication().getSharedPreferences("default", android.content.Context.MODE_PRIVATE)
    }

    single<SharedPreferences.Editor> {
        androidApplication().getSharedPreferences("default", android.content.Context.MODE_PRIVATE)
            .edit()
    }
}