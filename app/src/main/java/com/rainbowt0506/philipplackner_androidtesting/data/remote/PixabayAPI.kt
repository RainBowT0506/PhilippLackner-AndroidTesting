package com.rainbowt0506.philipplackner_androidtesting.data.remote

import com.rainbowt0506.philipplackner_androidtesting.BuildConfig
import com.rainbowt0506.philipplackner_androidtesting.data.remote.responses.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayAPI {

    @GET
    suspend fun searchForImage(
        @Query("q") searchQuery: String,
        @Query("key") apiKey: String = BuildConfig.API_KEY
    ): Response<ImageResponse>
}