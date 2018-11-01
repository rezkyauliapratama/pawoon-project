package android.rezkyauliapratama.com.pawoonprojecttodolist.screens.listpage

import android.rezkyauliapratama.com.pawoonprojecttodolist.data.database.entity.TodoSchema
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common.views.ViewMvc


interface TodolistViewMvc: ViewMvc{


    fun bindList(todos: List<TodoSchema>)
    fun showToast()

}