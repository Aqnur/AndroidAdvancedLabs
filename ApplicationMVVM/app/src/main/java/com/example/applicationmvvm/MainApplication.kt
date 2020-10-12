package com.example.applicationmvvm

import android.app.Application
import com.example.applicationmvvm.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                viewModelModule,
                useCaseModule,
                repositoryModule,
                networkModule,
                sharedPrefModule
            )
        }
    }
}