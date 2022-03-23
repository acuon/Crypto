package dev.acuon.crypto.di

import dev.acuon.crypto.data.api.APIService
import org.koin.dsl.module
import retrofit2.Retrofit
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dev.acuon.crypto.data.models.mapper.CryptoListMapper
import dev.acuon.crypto.data.providers.RetrofitProvider
import dev.acuon.crypto.data.repository.CryptoListRepository
import dev.acuon.crypto.data.repository.CryptoRepositoryImpl
import dev.acuon.crypto.ui.cryptolist.CryptoListViewModel
import dev.acuon.crypto.utils.Constants
import org.koin.android.viewmodel.dsl.viewModel

//apiServiceModule
val apiServicesModule = module {
    single<APIService> {
        get<Retrofit>().create(APIService::class.java)
    }
}

val appModule = module {
    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
}

val mappersModule = module {
    single { CryptoListMapper() }
}

val networkModule = module {
    single {
        RetrofitProvider(get(), Constants.BASE_URL).provide()
    }
}

val repoModule = module {
    single<CryptoListRepository> { CryptoRepositoryImpl(get(), get()) }
}

val viewModelsModule = module {
    viewModel { CryptoListViewModel(get()) }
}
