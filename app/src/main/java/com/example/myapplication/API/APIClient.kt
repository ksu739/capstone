package com.example.myapplication.API

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIClient {
    @POST("/login")
    fun login (@Body user:loginmodel ) : Call<loginreturnmodel>
}
