package com.shaadi.exercise.core.network

import android.util.Log
import java.io.IOException

/**
 * Created by Suyash Chavan.
 */
suspend fun <T : Any> safeApiCall(call: suspend () -> Outcome<T>, errorMsg: String): Outcome<T> {
    return try {
        call()
    } catch (e: Exception) {
        Log.e("Exception", e.toString())
        // Exception converting this to an IOException
        Outcome.Error(IOException(errorMsg, e))
    }
}