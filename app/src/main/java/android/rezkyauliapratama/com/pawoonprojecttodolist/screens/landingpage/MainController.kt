package android.rezkyauliapratama.com.pawoonprojecttodolist.screens.landingpage

import android.rezkyauliapratama.com.pawoonprojecttodolist.data.database.entity.TodoSchema
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common.controller.BaseController
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common.screennavigator.ScreensNavigator
import android.rezkyauliapratama.com.pawoonprojecttodolist.usecase.TodoUseCase
import org.jetbrains.anko.error


class MainController (val screensNavigator: ScreensNavigator, private val todoUseCase: TodoUseCase) : BaseController()
    , MainViewMvc.Listener , TodoUseCase.Listener{
    private lateinit var mViewMvc: MainViewMvc

    override fun onButtonClicked() {
        screensNavigator.toTodolistActivity()
    }

    override fun onFetchTodoSuccess(response: Array<TodoSchema>) {
        mViewMvc.hideProgressIndication()
    }

    override fun onFetchTodoFailure(message: String) {
        mViewMvc.hideProgressIndication()
        error { "failure : $message" }
    }

    fun bindView(viewMvc: MainViewMvc) {
        mViewMvc = viewMvc
    }

    fun onStart(){
        mViewMvc.registerListener(this)
        todoUseCase.registerListener(this)

        mViewMvc.showProgressIndication()
        todoUseCase.FetchApiAndNotify()
    }

    fun onStop(){
        mViewMvc.unregisterListener(this)
        todoUseCase.unregisterListener(this)
    }

}