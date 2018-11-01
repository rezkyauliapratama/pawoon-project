package android.rezkyauliapratama.com.pawoonprojecttodolist.di.controller

import android.content.Context
import android.support.v4.app.FragmentActivity
import dagger.Module
import dagger.Provides
/**
 * Created by Rezky Aulia Pratama on 15/8/18.
 */
@Module
class ActivityModule(val activity: FragmentActivity){

    @Provides
    @ActivityContext
    fun providesContext(): Context = activity

    @Provides
    fun provideActivity(): FragmentActivity = activity


}