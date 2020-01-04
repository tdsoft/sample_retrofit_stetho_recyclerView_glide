package com.funnystudio.samplelistapp

import android.app.Application
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class App : Application() {
    lateinit var retrofit: Retrofit

    companion object{
        var instance:App? = null
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        instance = this

        val client = OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

}