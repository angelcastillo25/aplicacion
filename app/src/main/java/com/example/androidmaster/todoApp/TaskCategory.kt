package com.example.androidmaster.todoApp

sealed class TaskCategory {
    object Personal: TaskCategory()
    object Bussines: TaskCategory()
    object  Other: TaskCategory()
}