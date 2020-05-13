package com.example.pandasoft.di

import android.content.Context
import android.content.SharedPreferences
import com.example.pandasoft.api.APIService
import com.example.pandasoft.ui.login.LoginRepository
import com.example.pandasoft.ui.login.LoginViewModel
import com.example.pandasoft.ui.news.page.newList.NewListRepository
import com.example.pandasoft.ui.news.page.newList.NewListViewModel
import com.example.pandasoft.ui.news.page.newSingle.NewSingleRepository
import com.example.pandasoft.ui.news.page.newSingle.NewSingleViewModel
import com.example.pandasoft.util.AppExecutors
import com.example.pandasoft.util.DateTimeConverter
import com.example.pandasoft.util.PreferenceData
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor


val applicationModule = module {

    single { AppExecutors() }
    single { LoginRepository(get(), get()) }
    single { NewListRepository(get() , get()) }
    single { NewSingleRepository(get(), get()) }
    viewModel { LoginViewModel(get() , get() , get()) }
    viewModel { NewListViewModel(get() ,get()) }
    viewModel { NewSingleViewModel(get() , get() , get()) }

    single { PreferenceData(get())}
    single { DateTimeConverter() }

    single {provideDefaultOkHttpClient()}
    single {provideRetrofit(get())}
    single {provideTmdbService(get())}
}

fun provideDefaultOkHttpClient() : OkHttpClient{
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
}

fun provideRetrofit(client : OkHttpClient) : Retrofit{
    return Retrofit.Builder()
        .baseUrl("https://5c065a3fc16e1200139479cc.mockapi.io/api/v1/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}

fun provideTmdbService(retrofit : Retrofit): APIService = retrofit.create(APIService::class.java)