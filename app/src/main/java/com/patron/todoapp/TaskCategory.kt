package com.patron.todoapp

sealed class TaskCategory {

    object  personal : TaskCategory ()
    object  business : TaskCategory ()
    object  others : TaskCategory ()


}

