package com.example.androidmaster.todoApp

data class Task(val name: String, val category: TaskCategory, val isSelected: Boolean = false)