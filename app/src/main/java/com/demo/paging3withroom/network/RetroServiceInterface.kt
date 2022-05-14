package com.demo.paging3withroom.network

import com.demo.paging3withroom.model.UserData
import com.demo.paging3withroom.model.UsersList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Rohith S
 * RetroServiceInterface defines the function headers to be used to an REST API
 */
interface RetroServiceInterface {

    @GET("apod")
    fun getContacts(@Query("api_key") api_key: String,
                    @Query ("count") count: String?
    ): Call<List<UserData?>?>?
}