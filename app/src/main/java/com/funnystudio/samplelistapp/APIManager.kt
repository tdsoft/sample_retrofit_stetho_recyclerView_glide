package com.funnystudio.samplelistapp

import retrofit2.Callback

object APIManager {
    fun getPhotos(callBack:Callback<List<MyPhoto>>){
        App.instance!!.retrofit.create(APIService::class.java)
            .getPhotos()
            .enqueue(callBack)
    }
}