package com.shaadi.exercise.features.shaadimatches.data.source

import com.shaadi.exercise.core.network.NetworkException
import com.shaadi.exercise.core.network.Outcome
import com.shaadi.exercise.core.network.safeApiCall
import com.shaadi.exercise.features.shaadimatches.data.ShaadiMatchesContract
import com.shaadi.exercise.features.shaadimatches.data.response.GetShaadiMatchesResponse

/**
 * Created by Suyash Chavan.
 */
class ShaadiMatchesRemoteDataSource(
    private val shaadiMatchesApi: ShaadiMatchesApi
): ShaadiMatchesContract.ShaadiMatchesRemoteDataSource {

    override suspend fun getShaadiMatches(
        count: Int
    ): Outcome<GetShaadiMatchesResponse> =  safeApiCall(
        call = {
            requestGetShaadiMatches(
                count
            )
        },
        errorMsg = "Unable to get shaadi matches"
    )

    private suspend fun requestGetShaadiMatches(
        count: Int
    ): Outcome<GetShaadiMatchesResponse> {
        val response = shaadiMatchesApi.getShaadiMatches(count)
        if(response.isSuccessful) {
            val body = response.body()
            if (body != null && body.results.isNotEmpty()) {
                val data = body.results
                return Outcome.Success(data)
            }
        }
        return Outcome.Error(NetworkException("Error while getting shaadi matches ${response.code()} ${response.message()}"))
    }

    companion object {

        fun getInstance(
            shaadiMatchesApi: ShaadiMatchesApi
        ): ShaadiMatchesRemoteDataSource {
            return ShaadiMatchesRemoteDataSource(shaadiMatchesApi)
        }

    }
}