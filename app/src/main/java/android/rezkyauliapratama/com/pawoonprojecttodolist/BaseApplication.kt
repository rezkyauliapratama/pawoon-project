package android.rezkyauliapratama.com.pawoonprojecttodolist

import android.app.Application
import android.rezkyauliapratama.com.pawoonprojecttodolist.di.application.ApplicationComponent
import android.rezkyauliapratama.com.pawoonprojecttodolist.di.application.ApplicationModule
import android.rezkyauliapratama.com.pawoonprojecttodolist.di.application.DaggerApplicationComponent
import android.rezkyauliapratama.com.pawoonprojecttodolist.di.application.NetworkModule
import com.app.infideap.stylishwidget.view.Stylish


class BaseApplication : Application(){

    companion object {
        lateinit var component : ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = initDagger(this)
        component.inject(this)

        val fontFolder = "fonts/Nunito/Nunito-"

        Stylish.getInstance().set(
            fontFolder + "Regular.ttf",
            fontFolder + "Bold.ttf",
            fontFolder + "Italic.ttf",
            fontFolder + "BoldItalic.ttf"
        )

        Stylish.getInstance().fontScale = 1f
    }

    private fun initDagger(app: BaseApplication): ApplicationComponent =
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(app))
            .networkModule(NetworkModule())
            .build()



}