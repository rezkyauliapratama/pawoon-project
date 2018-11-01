package android.rezkyauliapratama.com.pawoonprojecttodolist.screens.listpage

import android.rezkyauliapratama.com.pawoonprojecttodolist.databinding.ActivityTodolistBinding
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common.controller.BaseActivity


class TodolistActivity : BaseActivity<TodolistController, TodolistViewMvc, ActivityTodolistBinding>() {

    override fun initDataBinding() {
        mDataBinding = mViewMvc.dataBinding as ActivityTodolistBinding
    }

    override fun initView() {
        mViewMvc = viewMvcFactory.getTodoListViewMvc(null)
        mController.bindView(mViewMvc)
    }

    override fun inject() {
        controllerComponent.inject(this)
    }

    override fun onStart() {
        super.onStart()
        mController.onStart()
    }

    override fun onStop() {
        super.onStop()
        mController.onStop()
    }

}
