package android.rezkyauliapratama.com.pawoonprojecttodolist.screens.listpage

import android.databinding.DataBindingUtil
import android.rezkyauliapratama.com.pawoonprojecttodolist.R
import android.rezkyauliapratama.com.pawoonprojecttodolist.R.attr.layoutManager
import android.rezkyauliapratama.com.pawoonprojecttodolist.data.database.entity.TodoSchema
import android.rezkyauliapratama.com.pawoonprojecttodolist.databinding.ActivityTodolistBinding
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common.ViewMvcFactory
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common.views.BaseViewMvc
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v7.widget.DividerItemDecoration
import android.widget.Toast


class TodolistViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?, viewMvcFactory: ViewMvcFactory) :
    BaseViewMvc(), TodolistViewMvc{

    var binding : ActivityTodolistBinding = DataBindingUtil.inflate(inflater, R.layout.activity_todolist,parent,false)
    private var adapter: ItemsRvAdapter

    init{
        dataBinding = binding


        adapter = ItemsRvAdapter()
        binding.rvList.layoutManager = LinearLayoutManager(getContext())
        binding.rvList.adapter = adapter


        binding.rvList.addItemDecoration(
            DividerItemDecoration(
                getContext()!!,
                DividerItemDecoration.VERTICAL
            )
        )

    }

    override fun showToast() {
        Toast.makeText(getContext(),"Sorry , cannot load your todo list",Toast.LENGTH_LONG).show()
    }


    override fun bindList(todos: List<TodoSchema>) {
        adapter.bindItems(todos)
    }

}