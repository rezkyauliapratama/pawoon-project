package android.rezkyauliapratama.com.pawoonprojecttodolist.data.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.rezkyauliapratama.com.pawoonprojecttodolist.data.database.entity.TodoSchema
import org.jetbrains.anko.db.*


class MyDatabaseOpenHelper (ctx: Context, name :String, version : Int) : ManagedSQLiteOpenHelper(ctx, name, null, version) {


    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable(TodoSchema.TABLE_TODO, true,
            TodoSchema.ID to INTEGER + PRIMARY_KEY,
            TodoSchema.USER_ID to INTEGER,
            TodoSchema.TITLE to TEXT,
            TodoSchema.COMPLETED to INTEGER
        )

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable(TodoSchema.TABLE_TODO, true)
    }
}