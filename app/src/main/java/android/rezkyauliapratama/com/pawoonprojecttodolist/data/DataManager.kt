package android.rezkyauliapratama.com.pawoonprojecttodolist.data

import android.rezkyauliapratama.com.pawoonprojecttodolist.data.database.DatabaseRepository
import android.rezkyauliapratama.com.pawoonprojecttodolist.data.network.ApiRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DataManager @Inject constructor(){

    @Inject
    lateinit var db: DatabaseRepository

    @Inject
    lateinit var api: ApiRepository

}