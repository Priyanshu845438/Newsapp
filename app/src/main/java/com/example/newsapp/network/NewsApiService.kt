package com.example.newsapp.network

import com.example.newsapp.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    // Define the endpoint for top headlines
    @GET("v2/top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Call<NewsResponse>
}
