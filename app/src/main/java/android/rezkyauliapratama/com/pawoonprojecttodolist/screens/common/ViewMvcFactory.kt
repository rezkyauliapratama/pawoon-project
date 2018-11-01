package android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common

import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.landingpage.MainViewMvc
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.landingpage.MainViewMvcImpl
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.listpage.TodolistViewMvcImpl
import android.view.LayoutInflater
import android.view.ViewGroup

class ViewMvcFactory(private val mLayoutInflater: LayoutInflater) {
    fun getMainViewMvc(parent: ViewGroup?): MainViewMvc {
        return MainViewMvcImpl(mLayoutInflater, parent, this)
    }

    fun getTodoListViewMvc(parent: ViewGroup?): TodolistViewMvcImpl {
        return TodolistViewMvcImpl(mLayoutInflater, parent, this)
    }


}
