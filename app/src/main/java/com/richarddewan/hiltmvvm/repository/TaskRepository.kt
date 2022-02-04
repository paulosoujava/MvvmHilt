package com.richarddewan.hiltmvvm.repository

import com.richarddewan.hiltmvvm.data.local.entity.TaskLocalEntity
import com.richarddewan.hiltmvvm.util.ResultState
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    suspend fun getTasks(): Flow<ResultState<List<TaskLocalEntity>>>

    //suspend fun  addTask(task: TaskNetworkRequest): Flow<ResultState<List<TaskLocalEntity>>>
}