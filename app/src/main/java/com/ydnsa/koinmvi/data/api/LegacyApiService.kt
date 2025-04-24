package com.ydnsa.koinmvi.data.api

import com.ydnsa.koinmvi.data.model.Client
import retrofit2.http.GET



interface LegacyApiService {

    @GET("products")
    suspend fun getProduct():List<Client>
}