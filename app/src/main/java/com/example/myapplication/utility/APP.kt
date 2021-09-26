package com.example.myapplication.utility

import android.app.Application
import com.example.myapplication.API.APIClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APP : Application() {
    companion object {
        lateinit var prefs: PreferenceUtil
        lateinit var service: APIClient
    }

    override fun onCreate() {
        prefs = PreferenceUtil(applicationContext)
        service = Retrofit.Builder()
            .baseUrl("https://capstone-sch.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(APIClient::class.java)

        super.onCreate()
    }
}
