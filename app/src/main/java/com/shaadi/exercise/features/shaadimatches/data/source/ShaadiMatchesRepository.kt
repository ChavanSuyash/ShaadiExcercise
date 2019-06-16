package com.shaadi.exercise.features.shaadimatches.data.source

import com.shaadi.exercise.core.network.Outcome
import com.shaadi.exercise.features.shaadimatches.data.ShaadiMatchesContract
import com.shaadi.exercise.features.shaadimatches.data.response.GetShaadiMatchesResponse

/**
 * Created by Suyash Chavan.
 */
class ShaadiMatchesRepository (
    private val shaadiMatchesRemoteDataSource: ShaadiMatchesRemoteDataSource
): ShaadiMatchesContract.ShaadiMatchesRepository {

    override suspend fun OnGetShaadiMatches(count: Int): Outcome<GetShaadiMatchesResponse> {
        return shaadiMatchesRemoteDataSource.getShaadiMatches(
            count
        )
    }

    companion object {

        fun getInstance(
            shaadiMatchesRemoteDataSource: ShaadiMatchesRemoteDataSource
        ): ShaadiMatchesRepository {
            return ShaadiMatchesRepository(shaadiMatchesRemoteDataSource)
        }

    }

}