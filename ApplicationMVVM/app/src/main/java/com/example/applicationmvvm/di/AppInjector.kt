package com.example.applicationmvvm.di

import android.content.SharedPreferences
import com.example.applicationmvvm.domain.GetPokemonListUseCase
import com.example.applicationmvvm.model.api.RetrofitService.getPostApi
import com.example.applicationmvvm.domain.PokemonListRepository
import com.example.applicationmvvm.model.repository.PokemonListDataStore
import com.example.applicationmvvm.viewModel.PokemonListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PokemonListViewModel(getPokemonListUseCase = get()) }
}

val useCaseModule = module {
    single { GetPokemonListUseCase(pokemonListRepository = get<PokemonListDataStore>()) }
}

val repositoryModule = module {
    single { PokemonListDataStore(apiService = get()) }
}

val networkModule = module {
    single { getPostApi() }
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