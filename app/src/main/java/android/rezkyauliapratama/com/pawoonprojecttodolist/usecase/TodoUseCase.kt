package android.rezkyauliapratama.com.pawoonprojecttodolist.usecase

import android.rezkyauliapratama.com.pawoonprojecttodolist.data.DataManager
import android.rezkyauliapratama.com.pawoonprojecttodolist.data.database.entity.TodoSchema
import android.rezkyauliapratama.com.pawoonprojecttodolist.data.network.ApiObservable
import android.rezkyauliapratama.com.pawoonprojecttodolist.data.network.model.Todo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class TodoUseCase @Inject constructor(private val dataManager: DataManager) : ApiObservable<TodoUseCase.Listener>() {

    interface Listener {
        fun onFetchTodoSuccess(response: Array<TodoSchema>)
        fun onFetchTodoFailure(message: String)
    }

    fun FetchApiAndNotify(){
        compositeDisposable.add(dataManager.api
            .todo
            .getTodos()
            .map { it ->
                val todos = mutableListOf<TodoSchema>()
                for (todo: Todo in it){
                    val todoSchema = TodoSchema(todo.id,todo.userId,todo.title,if(todo.completed)1 else 0)
                    val b = dataManager.db.manageTodo.insert(todoSchema)
                    if (b)
                        todos.add(todoSchema)
                }
                todos
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                notifySuccess(response.toTypedArray())
            }) { throwable ->
                notifyFailure(throwable.localizedMessage)
            })

    }

    fun getQueryAndNotify(){
        compositeDisposable.add(dataManager.db
            .manageTodo
            .loadAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                notifySuccess(response.toTypedArray())
            }) { throwable ->
                notifyFailure(throwable.localizedMessage)
            })

    }

    private fun notifyFailure(message: String) {
        for (listener in listeners) {
            listener.onFetchTodoFailure(message)
        }
    }

    private fun notifySuccess(response :Array<TodoSchema>) {

        for (listener in listeners) {
            listener.onFetchTodoSuccess(response)
        }
    }

}
