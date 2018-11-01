package android.rezkyauliapratama.com.pawoonprojecttodolist.screens.listpage

import android.rezkyauliapratama.com.pawoonprojecttodolist.data.database.entity.TodoSchema
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common.controller.BaseController
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common.screennavigator.ScreensNavigator
import android.rezkyauliapratama.com.pawoonprojecttodolist.usecase.TodoUseCase
import android.widget.Toast
import org.jetbrains.anko.error
import java.util.*


class TodolistController(private val todoUseCase: TodoUseCase): BaseController(),
    TodoUseCase.Listener{


    private lateinit var mViewMvc: TodolistViewMvc

    fun bindView(viewMvc: TodolistViewMvc) {
        mViewMvc = viewMvc
    }

    override fun onFetchTodoSuccess(response: Array<TodoSchema>) {
        mViewMvc.bindList(response.toMutableList())
    }

    override fun onFetchTodoFailure(message: String) {
        error { "onfetchTodoFailure : $message" }
        mViewMvc.showToast()
    }


    fun onStart(){
        todoUseCase.registerListener(this)
        todoUseCase.getQueryAndNotify()
    }

    fun onStop(){
        todoUseCase.unregisterListener(this)
    }




}