package com.richarddewan.hiltmvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.richarddewan.hiltmvvm.data.local.entity.TaskLocalEntity
import com.richarddewan.hiltmvvm.repository.TaskRepositoryImpl
import com.richarddewan.hiltmvvm.util.ResultState
import com.richarddewan.hiltmvvm.util.event.TaskEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor (private val taskRepository: TaskRepositoryImpl) : ViewModel() {

    private val _state: MutableLiveData<ResultState<List<TaskLocalEntity>>> = MutableLiveData()
    val state: LiveData<ResultState<List<TaskLocalEntity>>>
        get() = _state
    //val taskRequest : MutableLiveData<TaskNetworkRequest> = MutableLiveData()

    fun  setTaskState(taskEvent: TaskEvent) {
        viewModelScope.launch {
            when(taskEvent) {
                is TaskEvent.GetTask -> {
                    taskRepository.getTasks()
                        .onEach {
                            _state.value = it
                        }
                        .launchIn(viewModelScope)

                }
                is TaskEvent.AddTask -> {
                    /*taskRequest.value?.let { task->
                        taskRepository.addTask(task)
                            .onEach {
                                _state.value = it
                            }
                            .launchIn(viewModelScope)
                    }*/
                }
                is TaskEvent.DeleteTask -> {

                }
                is TaskEvent.None -> {

                }
            }
        }
    }
}