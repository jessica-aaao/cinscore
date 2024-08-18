package com.example.cinscore.api

import retrofit2.Call
import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoints {
    @Headers("x-apisports-key: 6fbdaf1eb0b978f8c3f8fca57f34074e")
    @GET("countries")
    fun getCountries() : Call<JsonObject>

    @Headers("x-apisports-key: 6fbdaf1eb0b978f8c3f8fca57f34074e")
    @GET("leagues")
    fun getLeagues(): Call<JsonObject>

    @Headers("x-apisports-key: 6fbdaf1eb0b978f8c3f8fca57f34074e")
    @GET("teams")
    fun getTeams(): Call<JsonObject>

    @Headers("x-apisports-key: 6fbdaf1eb0b978f8c3f8fca57f34074e")
    @GET("games")
    fun getGamesByDate(
        @Query("date") date: String
    ) : Call<JsonObject>
}