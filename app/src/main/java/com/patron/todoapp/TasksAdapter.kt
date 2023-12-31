package com.patron.todoapp

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TasksAdapter(var task: List<Task>, private val onItemSelected: (Int) -> Unit) :
    RecyclerView.Adapter<TasksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TasksViewHolder(view)
    }

    override fun getItemCount() = task.size

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {

        holder.render(task[position])
        holder.itemView.setOnClickListener {
            onItemSelected(position)
            Log.i("Alfonso", " Holi ${position}")

        }

    }

}