package com.example.mvvmsample

import android.app.Application
import com.example.mvvmsample.data.db.AppDatabase
import com.example.mvvmsample.data.db.PreferenceProvider
import com.example.mvvmsample.data.network.MyApi
import com.example.mvvmsample.data.network.NetworkConnectionInterceptor
import com.example.mvvmsample.data.repository.QuotesRepository
import com.example.mvvmsample.data.repository.UserRepository
import com.example.mvvmsample.ui.auth.AuthViewModelFactory
import com.example.mvvmsample.ui.profile.ProfileViewModelFactory
import com.example.mvvmsample.ui.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMSample : Application(), KodeinAware {

    override val kodein = Kodein.lazy {

        import(androidXModule(this@MVVMSample))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { UserRepository(instance(), instance())}
        bind() from singleton { QuotesRepository(instance(),instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }
    }

}