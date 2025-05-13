package com.ydnsa.koinmvi.data.network.api

import com.ydnsa.koinmvi.data.network.model.Client
import retrofit2.http.GET



interface LegacyApiService {

    @GET("products")
    suspend fun getProduct():List<Client>
}