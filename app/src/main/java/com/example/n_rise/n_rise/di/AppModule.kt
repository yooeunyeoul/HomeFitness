package com.example.n_rise.n_rise.di

import android.content.Context
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.n_rise.n_rise.common.Constants
import com.example.n_rise.n_rise.common.Constants.PAGE_SIZE
import com.example.n_rise.n_rise.data.local.ProgramDatabase
import com.example.n_rise.n_rise.data.local.ProgramEntity
import com.example.n_rise.n_rise.data.remote.HealthApi
import com.example.n_rise.n_rise.data.remote.paging.ProgramRemotePagingSource
import com.example.n_rise.n_rise.data.repository.HealthRepositoryImpl
import com.example.n_rise.n_rise.domain.repository.HealthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideLocalDatabase(@ApplicationContext context: Context): ProgramDatabase {
        return Room.databaseBuilder(
            context,
            ProgramDatabase::class.java,
            "programs_db"
        ).build()
    }

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

    @Provides
    fun providePager(
        api: HealthApi
    ): Pager<Int, ProgramEntity> {
        return Pager(config = PagingConfig(pageSize = PAGE_SIZE)) {
            ProgramRemotePagingSource(api)
        }
    }
}