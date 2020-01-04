package com.funnystudio.samplelistapp

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("photos")
    fun getPhotos() : Call<List<MyPhoto>>
}