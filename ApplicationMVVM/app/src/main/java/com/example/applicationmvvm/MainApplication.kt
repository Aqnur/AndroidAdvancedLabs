package com.example.applicationmvvm

import android.app.Application
import com.example.applicationmvvm.di.networkModule
import com.example.applicationmvvm.di.repositoryModule
import com.example.applicationmvvm.di.sharedPrefModule
import com.example.applicationmvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(viewModelModule, repositoryModule, networkModule, sharedPrefModule)
        }
    }
}