package android.rezkyauliapratama.com.pawoonprojecttodolist.di.application

import android.rezkyauliapratama.com.pawoonprojecttodolist.BaseApplication
import android.rezkyauliapratama.com.pawoonprojecttodolist.data.DataManager
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class, DatabaseModule::class ,NetworkModule::class])
interface ApplicationComponent{

    fun getDataManager(): DataManager
    fun inject(baseApplication: BaseApplication)

}