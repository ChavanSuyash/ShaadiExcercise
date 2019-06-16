package com.shaadi.exercise.features.shaadimatches.data.dagger.module

import com.shaadi.exercise.features.shaadimatches.data.source.ShaadiMatchesApi
import com.shaadi.exercise.features.shaadimatches.data.source.ShaadiMatchesRemoteDataSource
import com.shaadi.exercise.features.shaadimatches.data.source.ShaadiMatchesRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Suyash Chavan.
 */
@Module
class ShaadiMatchesDataModule  {

    @Provides
    fun providesShaadiMatchesRepository(
        shaadiMatchesRemoteDataSource: ShaadiMatchesRemoteDataSource
    ) : ShaadiMatchesRepository {
        return ShaadiMatchesRepository.getInstance(
            shaadiMatchesRemoteDataSource
        )
    }

    @Provides
    fun providesShaadiMatchesRemoteDataSource(shaadiMatchesApi : ShaadiMatchesApi) : ShaadiMatchesRemoteDataSource {
        return ShaadiMatchesRemoteDataSource.getInstance(shaadiMatchesApi)
    }

    @Provides
    fun providesAuthApi(retrofit: Retrofit) : ShaadiMatchesApi {
        return retrofit.create(ShaadiMatchesApi::class.java)
    }
}