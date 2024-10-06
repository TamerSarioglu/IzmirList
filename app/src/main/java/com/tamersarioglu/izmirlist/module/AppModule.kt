package com.tamersarioglu.izmirlist.module

import com.tamersarioglu.izmirlist.data.service.ServiceRepository
import com.tamersarioglu.izmirlist.data.service.ServiceRepositoryImpl
import com.tamersarioglu.izmirlist.domain.ServiceApi
import com.tamersarioglu.izmirlist.presentation.screens.neighborhoodbazaarplacesscreen.NeighborhoodBazaarPlacesScreenViewModel
import com.tamersarioglu.izmirlist.presentation.screens.wifiservicelocationlistscreen.WifiServiceLocationListScreenViewModel
import com.tamersarioglu.izmirlist.presentation.usecases.GetWifiServicesUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { provideRetrofit() }
    single<ServiceApi> { get<Retrofit>().create(ServiceApi::class.java) }
    single<ServiceRepository> { ServiceRepositoryImpl(get()) }
    factory { GetWifiServicesUseCase(get()) }
    viewModel { WifiServiceLocationListScreenViewModel(get()) }
    viewModel { NeighborhoodBazaarPlacesScreenViewModel() }
}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://openapi.izmir.bel.tr/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}