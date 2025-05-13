package com.ydnsa.koinmvi.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Client(
    @Json(name = "id") val id: String,  // Changed to String
    @Json(name = "name") val name: String,
    @Json(name = "image") val image: String,
    @Json(name = "price") val price: Int
)
