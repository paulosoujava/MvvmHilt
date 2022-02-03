package com.richarddewan.hiltmvvm.data.remote

import com.richarddewan.hiltmvvm.data.remote.response.Person
import retrofit2.http.GET

interface NetworkService {

    @GET(EndPoint.GET_ALL)
    suspend fun getAllTask(): List<Person>
}

