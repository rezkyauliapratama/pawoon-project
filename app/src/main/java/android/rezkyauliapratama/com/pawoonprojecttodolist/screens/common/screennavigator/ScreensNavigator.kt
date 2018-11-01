package android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common.screennavigator

import android.app.Activity
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.landingpage.MainActivity
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.listpage.TodolistActivity
import org.jetbrains.anko.ctx
import org.jetbrains.anko.startActivity


class ScreensNavigator(private val activity: Activity) {

    fun toTodolistActivity(){
        activity.ctx.startActivity<TodolistActivity>()
    }

}
