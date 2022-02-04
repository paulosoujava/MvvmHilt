package com.richarddewan.hiltmvvm.data.remote


import com.richarddewan.hiltmvvm.data.remote.response.TaskNetworkResponse
import retrofit2.http.GET

interface NetworkService {

    @GET(EndPoint.GET_ALL_TASK)
    suspend fun getAllTask(): List<TaskNetworkResponse.TaskNetworkResponseItem>
}

