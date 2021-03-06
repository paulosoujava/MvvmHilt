package com.richarddewan.hiltmvvm.repository

import com.richarddewan.hiltmvvm.data.local.dao.TaskDao
import com.richarddewan.hiltmvvm.data.local.entity.TaskEntityMapper
import com.richarddewan.hiltmvvm.data.local.entity.TaskLocalEntity
import com.richarddewan.hiltmvvm.data.remote.NetworkService
import com.richarddewan.hiltmvvm.util.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class TaskRepositoryImpl(
    private val networkService: NetworkService,
    private val taskDao: TaskDao,
    private val taskEntityMapper: TaskEntityMapper
): TaskRepository {

    override suspend fun getTasks(): Flow<ResultState<List<TaskLocalEntity>>> = flow {
        emit(ResultState.Loading)
        try {
            val response = networkService.getAllTask()
            val taskList = taskEntityMapper.mapToEntityList(response)
            taskDao.insertMany(taskList)

            val task = taskDao.getTasks()
            emit(ResultState.Success(task))
        }
        catch (e: Exception) {
            emit(ResultState.Error(e))
        }

    }

   /* override suspend fun addTask(task: TaskNetworkRequest): Flow<ResultState<List<TaskLocalEntity>>> =  flow {
        emit(ResultState.Loading)
        try {
            val response = networkService.addTask(task)
            val taskResponse = taskEntityMapper.mapToEntity(response)
            taskDao.inset(taskResponse)
            emit(ResultState.Success(taskDao.getTasks()))

        }catch (e:Exception) {
            emit(ResultState.Error(e))
        }
    }*/
}