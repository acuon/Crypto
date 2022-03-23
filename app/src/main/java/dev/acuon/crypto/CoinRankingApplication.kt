package dev.acuon.crypto

import android.app.Application
import dev.acuon.crypto.di.apiServicesModule
import dev.acuon.crypto.di.appModule
import dev.acuon.crypto.di.mappersModule
import dev.acuon.crypto.di.networkModule
import dev.acuon.crypto.di.repoModule
import dev.acuon.crypto.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CoinRankingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@CoinRankingApplication)
            modules(appModule, networkModule, repoModule, apiServicesModule, viewModelsModule, mappersModule)
        }
    }
}