package com.groupal.marketplace.di

import com.groupal.marketplace.common.utils.Constants
import com.groupal.marketplace.data.service.IProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
//
//    @Singleton
//    @Provides
//    fun provideIMenuService(retrofit: Retrofit):IMenuService{
//        return retrofit.create(IMenuService::class.java)
//    }

    @Singleton
    @Provides
    fun provideIMovieService(retrofit: Retrofit): IProductService {
        return retrofit.create(IProductService::class.java)
    }
}

