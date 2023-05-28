package com.example.todolistapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TasksAdapter(private val tasks: List<Task>) : RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}