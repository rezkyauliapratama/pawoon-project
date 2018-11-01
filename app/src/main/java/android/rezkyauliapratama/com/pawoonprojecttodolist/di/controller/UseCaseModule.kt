package android.rezkyauliapratama.com.mmppdc.di.controller

import android.rezkyauliapratama.com.pawoonprojecttodolist.data.DataManager
import android.rezkyauliapratama.com.pawoonprojecttodolist.data.network.model.Todo
import android.rezkyauliapratama.com.pawoonprojecttodolist.usecase.TodoUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule{
    @Provides
    fun getTodoUseCase(dataManager: DataManager) : TodoUseCase{
        return TodoUseCase(dataManager)
    }

}