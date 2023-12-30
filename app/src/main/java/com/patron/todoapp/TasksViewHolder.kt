package com.patron.todoapp

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvTask : TextView = view.findViewById(R.id.tvTask)
    private val checkboxTask : CheckBox = view.findViewById(R.id.checkboxTask)

    fun render(task : Task){

        tvTask.text = task.name
    }


}