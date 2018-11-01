package android.rezkyauliapratama.com.pawoonprojecttodolist.data.network

import android.rezkyauliapratama.com.pawoonprojecttodolist.data.network.api.TodoApi
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Rezky Aulia Pratama on 11/9/18.
 */


@Singleton
class ApiRepository @Inject constructor(){


    @Inject
    lateinit var todo: TodoApi

    //add another management file in here if it've more than 1 api

}