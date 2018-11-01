package android.rezkyauliapratama.com.pawoonprojecttodolist.data.database.manage

import android.rezkyauliapratama.com.pawoonprojecttodolist.data.database.MyDatabaseOpenHelper
import android.rezkyauliapratama.com.pawoonprojecttodolist.data.database.entity.TodoSchema
import com.google.gson.Gson
import io.reactivex.Observable
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.replace
import org.jetbrains.anko.db.select
import org.jetbrains.anko.error
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ManageTodo @Inject constructor(val db: MyDatabaseOpenHelper) : AnkoLogger {

    /**
     * Method to retrieve all data _todo from table
     * @return List<TodoSchema>
     */    fun loadAll(): Observable<List<TodoSchema>> {
        var todos = ArrayList<TodoSchema>()
        db.use {
            select(TodoSchema.TABLE_TODO).parseList(object : MapRowParser<List<TodoSchema>> {

                override fun parseRow(columns : Map<String, Any?>) : List<TodoSchema> {

                    val id : Long= columns.getValue(TodoSchema.ID) as Long
                    val userId : Long = columns.getValue(TodoSchema.USER_ID) as Long
                    val title : String = columns.getValue(TodoSchema.TITLE) as String
                    val completed : Long = columns.getValue(TodoSchema.COMPLETED) as Long


                    val todo  = TodoSchema(id.toInt() , userId.toInt() , title , completed.toInt() )
                    todos.add(todo)

                    return todos
                }
            })

        }
        return Observable.just(todos)
    }

    /**
     * Insert 1 _todo into table
     * @param todoSchema is TodoSchema class with type dataclass
     * @return Boolean
     */
    fun insert(todoSchema: TodoSchema) : Boolean {
        var isAdded = false
        db.use {
            try {
                beginTransaction()
                val insertedId =  replace(TodoSchema.TABLE_TODO,
                    TodoSchema.ID to todoSchema.id,
                    TodoSchema.USER_ID to todoSchema.userId,
                    TodoSchema.TITLE to todoSchema.title,
                    TodoSchema.COMPLETED to todoSchema.completed
                )


                if (insertedId != -1L) {
                    setTransactionSuccessful()
                    isAdded = true
                } else {
                    isAdded = false
                }

            } catch (e : Throwable) {
                isAdded = false
                error{"cannot add : ${Gson().toJson(e)}"}
            } finally {
                endTransaction()
            }
        }
        return isAdded
    }
    /**
     * Remove 1 _todo from the table
     * @param id an Int that represent ID from TodoSchema Table
     * @return Boolean
     */
    fun delete(id : Int): Boolean {
        var isDeleted = false
        db.use {
            try {
                beginTransaction()
                val result = delete(TodoSchema.TABLE_TODO, "(${TodoSchema.ID} = {id})",
                    "id" to id) > 0
                isDeleted = if (result) {
                    setTransactionSuccessful()
                    true
                } else {
                    false
                }

            } catch (e : Throwable) {
                isDeleted = false
                error{"cannot delete : ${Gson().toJson(e)}"}
            } finally {
                endTransaction()
            }
        }
        return  isDeleted
    }


}