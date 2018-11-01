package android.rezkyauliapratama.com.pawoonprojecttodolist.di.controller

import android.rezkyauliapratama.com.mmppdc.di.controller.PerController
import android.rezkyauliapratama.com.mmppdc.di.controller.UseCaseModule
import android.rezkyauliapratama.com.pawoonprojecttodolist.di.application.ApplicationComponent
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.landingpage.MainActivity
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.listpage.TodolistActivity
import dagger.Component


/**
 * Created by Rezky Aulia Pratama on 15/8/18.
 */
@PerController
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class, MvcWrapperModule::class, ControllerModule::class, UseCaseModule::class])
interface ControllerComponent{

    fun inject(mainActivity: MainActivity)
    fun inject(todolistActivity: TodolistActivity)
}
