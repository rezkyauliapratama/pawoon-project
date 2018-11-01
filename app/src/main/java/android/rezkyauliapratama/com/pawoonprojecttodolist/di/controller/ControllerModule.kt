package android.rezkyauliapratama.com.pawoonprojecttodolist.di.controller

import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common.screennavigator.ScreensNavigator
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.landingpage.MainController
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.listpage.TodolistController
import android.rezkyauliapratama.com.pawoonprojecttodolist.usecase.TodoUseCase
import dagger.Module
import dagger.Provides

@Module
class ControllerModule {
    @Provides
    fun getHistoryController(screensNavigator: ScreensNavigator, todoUseCase: TodoUseCase) : MainController {
        return MainController(screensNavigator, todoUseCase)
    }

    @Provides
    fun getTodolistController(todoUseCase: TodoUseCase) : TodolistController{
        return TodolistController(todoUseCase)
    }
}