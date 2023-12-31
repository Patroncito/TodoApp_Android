package com.patron.todoapp

sealed class TaskCategory(var isSelected : Boolean = true) {

    object  personal : TaskCategory ()
    object  business : TaskCategory ()
    object  others : TaskCategory ()


}

