package com.ydnsa.koinmvi.data.network.api

import com.ydnsa.koinmvi.data.network.model.Client
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProduct():List<Client>
}