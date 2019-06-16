package com.shaadi.exercise.core.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by Suyash Chavan.
 */
@JsonClass(generateAdapter = true)
data class Wrapper<out T: Any>(

    @Json(name = "results")
    val results: T,

    @Json(name = "info")
    val info: Info? = null
)

@JsonClass(generateAdapter = true)
data class Info(
    val seed : String,
    val results: Int,
    val page: Int,
    val version: Float
)