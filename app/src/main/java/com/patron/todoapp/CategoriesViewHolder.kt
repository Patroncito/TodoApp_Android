package com.patron.todoapp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CategoriesViewHolder(view : View) : RecyclerView.ViewHolder(view){

    private val tvCategoryName : TextView = view.findViewById(R.id.tvCategoryName)
    private val divider : View = view.findViewById(R.id.divider)
    fun render(taskCategory : TaskCategory) {

        when (taskCategory) {
            TaskCategory.business -> {
                tvCategoryName.text = "Negocios"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.todo_business_category))
            }
            TaskCategory.personal -> {
                tvCategoryName.text = "Personal"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.todo_personal_category))

            }
            TaskCategory.others -> {
                tvCategoryName.text = "Otros"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.todo_other_category))

            }

        }

    }

}