package android.rezkyauliapratama.com.pawoonprojecttodolist.di.controller

import android.content.Context
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common.ViewMvcFactory
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common.screennavigator.ScreensNavigator
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides

@Module
class MvcWrapperModule{

    @Provides
    fun getViewMvcFactory(@ActivityContext context: Context): ViewMvcFactory {
        return ViewMvcFactory(LayoutInflater.from(context))
    }

    @Provides
    fun getScreensNavigator(activity: FragmentActivity): ScreensNavigator {
        return ScreensNavigator( activity)
    }

}