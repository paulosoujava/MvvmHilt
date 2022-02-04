package com.richarddewan.hiltmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.richarddewan.hiltmvvm.data.local.entity.TaskLocalEntity
import com.richarddewan.hiltmvvm.databinding.ActivityMainBinding
import com.richarddewan.hiltmvvm.ui.TaskViewModel
import com.richarddewan.hiltmvvm.util.ResultState
import com.richarddewan.hiltmvvm.util.event.TaskEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding!!.root)

        setObserver()
        viewModel.setTaskState(TaskEvent.GetTask)
    }

    private fun setObserver(){
        viewModel.state.observe( this) {
            when (it) {
                is ResultState.Loading -> {
                    setProgressBar(true)
                }
                is ResultState.Success -> {
                    setTaskList(it.data)
                }
                is ResultState.Error -> {
                    setError(it.exception.message)
                }
            }
        }
    }

    private fun setTaskList(task: List<TaskLocalEntity>) {

    }

    private fun setError(error: String?) {
        error?.let {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }

    private fun setProgressBar(isShow: Boolean) {
        binding.progressBar.visibility = if (isShow) View.VISIBLE else View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}