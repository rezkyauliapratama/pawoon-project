package android.rezkyauliapratama.com.pawoonprojecttodolist.data.database

import android.rezkyauliapratama.com.pawoonprojecttodolist.data.database.manage.ManageTodo
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DatabaseRepository @Inject constructor() {

    @Inject
    lateinit var manageTodo: ManageTodo

    //add the another management file in here if you have more than 1 table
}