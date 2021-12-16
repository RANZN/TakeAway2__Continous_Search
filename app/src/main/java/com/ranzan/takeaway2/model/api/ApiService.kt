package com.ranzan.takeaway2.model.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("autocomplete?queryString=airtel")
    suspend fun getData(@Query("city") city: String): ResponseModel

}