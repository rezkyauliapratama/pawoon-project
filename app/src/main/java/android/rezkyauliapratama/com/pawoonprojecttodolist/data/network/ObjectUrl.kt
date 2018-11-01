package android.rezkyauliapratama.com.pawoonprojecttodolist.data.network

import android.net.Uri
import android.rezkyauliapratama.com.pawoonprojecttodolist.BuildConfig
import org.jetbrains.anko.AnkoLogger

//class yang berisi url untuk API
object ObjectUrl : AnkoLogger {


    fun todo(): String{
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("todos")
                .build()
                .toString()
    }

}