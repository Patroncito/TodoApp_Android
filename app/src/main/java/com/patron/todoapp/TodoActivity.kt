package com.patron.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
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

    private val tasks = mutableListOf(
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



        taskAdapter = TasksAdapter(tasks) {onItemSelected(it)}
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter


    }

    private fun onItemSelected(position : Int){
        tasks[position].isSelected = !tasks[position].isSelected
        Log.i("Alfonso", tasks[position].isSelected.toString())
        updateTasks()
    }
    private fun initListeners() {

        fabAddTask.setOnClickListener{
            showDialog()
        }
    }

    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)


        val fabAddTask : Button = dialog.findViewById(R.id.btnAddTask)
        val edTextTask : EditText = dialog.findViewById(R.id.etDialog)
        val radioGroup : RadioGroup = dialog.findViewById(R.id.radioGroup)

        fabAddTask.setOnClickListener {

            if (edTextTask.text.isNotEmpty()){
                val selectedId = radioGroup.checkedRadioButtonId
                val selectedRadioButton : RadioButton= radioGroup.findViewById(selectedId)
                val taskText = edTextTask.text.toString()


                val currentCategory : TaskCategory = when(selectedRadioButton.text){
                    getString(R.string.bussiness) -> business
                    getString(R.string.personal) -> personal
                    else -> others
                }
                tasks.add(Task(edTextTask.text.toString(), currentCategory))
                updateTasks()
                dialog.hide()
            }

        }
        dialog.show()
    }

    private fun updateTasks(){
        taskAdapter.notifyDataSetChanged()
    }
}