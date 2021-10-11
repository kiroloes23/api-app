package com.example.test

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET

interface callinterface {
    @GET("/v2/top-headlines?country=eg&category=sports&apiKey=87f0c137616344d08579e3b4a7576a75")
    fun getnews(): Call<ipmodel>
}