package com.example.n_rise.n_rise.di

import com.example.n_rise.n_rise.domain.repository.HealthRepository
import com.example.n_rise.n_rise.common.Constants
import com.example.n_rise.n_rise.data.data_source.remote.HealthApi
import com.example.n_rise.n_rise.data.repository.HealthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideHealthApi(okHttpClient: OkHttpClient): HealthApi {
        return Retrofit.Builder()
            .baseUrl(
                Constants.BASE_URL
            )
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(HealthApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHealthRepository(api: HealthApi): HealthRepository {
        return HealthRepositoryImpl(api = api)
    }
}