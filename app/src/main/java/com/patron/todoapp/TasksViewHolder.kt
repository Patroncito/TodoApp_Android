package com.patron.todoapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvTask : TextView = view.findViewById(R.id.tvTask)
    private val checkboxTask : CheckBox = view.findViewById(R.id.checkboxTask)

    fun render(task : Task){

        if (task.isSelected) {
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            Log.i("Alfonso", "Cambiando a strike")
        } else {
            tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()

        }

        tvTask.text = task.name
        checkboxTask.isChecked = task.isSelected

        val color = when(task.category){
            TaskCategory.business -> R.color.todo_business_category
            TaskCategory.others -> R.color.todo_other_category
            TaskCategory.personal -> R.color.todo_personal_category
        }

        checkboxTask.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(checkboxTask.context, color)
        )


    }


}