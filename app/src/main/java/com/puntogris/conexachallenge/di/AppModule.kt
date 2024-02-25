package com.puntogris.conexachallenge.di

import com.puntogris.conexachallenge.data.repository.RepositoryImpl
import com.puntogris.conexachallenge.data.api.ApiService
import com.puntogris.conexachallenge.domain.Repository
import com.puntogris.conexachallenge.domain.DispatcherProvider
import com.puntogris.conexachallenge.data.utils.StandardDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService, dispatchers: DispatcherProvider): Repository {
        return RepositoryImpl(apiService, dispatchers)
    }

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideDispatcherProvider(): DispatcherProvider = StandardDispatchers()
}