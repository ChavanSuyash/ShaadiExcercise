package com.shaadi.exercise.features.shaadimatches.data

import com.shaadi.exercise.core.network.Outcome
import com.shaadi.exercise.features.shaadimatches.data.response.GetShaadiMatchesResponse

/**
 * Created by Suyash Chavan.
 */
class ShaadiMatchesContract  {

    interface ShaadiMatchesRemoteDataSource {
        suspend fun getShaadiMatches(count: Int): Outcome<GetShaadiMatchesResponse>
    }

    interface ShaadiMatchesRepository {
        suspend fun OnGetShaadiMatches(count: Int): Outcome<GetShaadiMatchesResponse>
    }

}