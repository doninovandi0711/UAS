package com.doni.uas

import retrofit2.Call
import retrofit2.http.GET

interface TVShowApiInterface {
    @GET("/3/tv/popular?api_key=5ceb1c7e41de3e28ac9730030013dba1")
    fun getTVShowList(): Call<TVShowResponse>
}