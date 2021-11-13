package com.example.Doggo2.network

import com.squareup.moshi.Json

data class DogApiResponse(
    @Json(name = "message")
    val message: String?,

    @Json(name = "success")
    val success: String?
        )
