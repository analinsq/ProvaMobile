package com.example.myapplication

import androidx.lifecycle.LiveData
import com.example.myapplication.dao.TaskDao

class TaskRepository(private val taskDao: TaskDao) {

    val allTasks: LiveData<List<Task>> = taskDao.getAllTasks()

    suspend fun insert(task: Task) {
        taskDao.insert(task)
    }
}
