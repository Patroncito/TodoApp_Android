package com.patron.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.patron.todoapp.TaskCategory.*

class TodoActivity : AppCompatActivity() {

    private val categories  = listOf(
        business,
        personal,
        others
    )

    private val task = mutableListOf(
        Task("Terminar aplicacion de TODO APP para subirlo a github", personal, false),
        Task("Enviar CV a Maquila", business, false),
        Task("Ir por Chicharones", others, false)
    )
    private lateinit var rvCategories : RecyclerView
    private lateinit var rvTasks : RecyclerView

    private lateinit var categoriesAdapter : CategoryAdapter
    private lateinit var taskAdapter : TasksAdapter

    private lateinit var fabAddTask : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        initComponent()
        initUI()
        initListeners()
    }




    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        categoriesAdapter = CategoryAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter



        taskAdapter = TasksAdapter(task)
        rvTasks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTasks.adapter = taskAdapter

    }

    private fun initListeners() {

        fabAddTask.setOnClickListener{


        }
    }
}