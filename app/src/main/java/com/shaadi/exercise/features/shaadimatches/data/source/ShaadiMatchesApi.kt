package com.shaadi.exercise.features.shaadimatches.data.source

import com.shaadi.exercise.core.network.Wrapper
import com.shaadi.exercise.features.shaadimatches.data.response.GetShaadiMatchesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Suyash Chavan.
 */
interface ShaadiMatchesApi {

    @GET(GET_USERS)
    suspend fun getShaadiMatches(
        @Query("results")
        count: Int
    ): Response<Wrapper<GetShaadiMatchesResponse>>

    companion object{
        private const val GET_USERS = "https://randomuser.me/api/"
    }
}