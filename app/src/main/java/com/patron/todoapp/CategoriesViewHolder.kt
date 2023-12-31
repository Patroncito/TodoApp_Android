package com.patron.todoapp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CategoriesViewHolder(view : View) : RecyclerView.ViewHolder(view){

    private val tvCategoryName : TextView = view.findViewById(R.id.tvCategoryName)
    private val divider : View = view.findViewById(R.id.divider)
    private val cardCategory : CardView = view.findViewById(R.id.cardCategory)
    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {

        val color = if (taskCategory.isSelected){
            R.color.todo_background_card
        } else {
            R.color.todo_background_disabled
        }

        cardCategory.setCardBackgroundColor(ContextCompat.getColor(cardCategory.context, color))

        itemView.setOnClickListener{ onItemSelected(layoutPosition) }

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