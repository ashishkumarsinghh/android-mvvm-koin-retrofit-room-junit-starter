package com.example.android_mvvm_koin_retrofit_room_junit_starter

import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {
    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>
}