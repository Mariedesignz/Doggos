package com.example.furrypal

import com.squareup.moshi.Json

data class DogPhoto(
    @Json(name = "message") val imageUrl: String?,
    val status: String?
)