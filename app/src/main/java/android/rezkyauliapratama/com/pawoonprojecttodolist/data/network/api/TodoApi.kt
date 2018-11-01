package android.rezkyauliapratama.com.pawoonprojecttodolist.data.network.api

import android.rezkyauliapratama.com.pawoonprojecttodolist.data.database.entity.TodoSchema
import android.rezkyauliapratama.com.pawoonprojecttodolist.data.network.ObjectUrl
import android.rezkyauliapratama.com.pawoonprojecttodolist.data.network.model.Todo
import com.rezkyaulia.android.light_optimization_data.NetworkClient
import io.reactivex.Single
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject


class TodoApi  @Inject constructor(private val networkClient: NetworkClient) : AnkoLogger {
    val TAG : String  = TodoApi::class.java.simpleName

    fun getTodos() : Single<Array<Todo>> {
        return Single.create<Array<Todo>> { emitter ->
            try {
                todos()
                    .apply { this?.let { emitter.onSuccess(it) } }
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }

    }


    private fun todos() : Array<Todo>?
    {

        try
        {
            return with(networkClient){
                cancelByTag(TAG)
                withUrl(ObjectUrl.todo())
                    .initAs(Array<Todo>::class.java)
                    .setTag(TAG)
                    .syncFuture
            }
        } catch (e: Exception) {
            throw e
        }

    }

}