package com.patron.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TodoActivity : AppCompatActivity() {

    private val categories  = listOf(
        TaskCategory.business,
        TaskCategory.personal,
        TaskCategory.others
    )
    private lateinit var rvCategories : RecyclerView
    private lateinit var categoriesAdapter : CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        initComponent()
        initUI()
    }


    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
    }

    private fun initUI() {
        categoriesAdapter = CategoryAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter
    }

}