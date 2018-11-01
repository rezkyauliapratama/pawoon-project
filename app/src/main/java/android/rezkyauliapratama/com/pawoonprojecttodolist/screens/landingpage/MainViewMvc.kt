package android.rezkyauliapratama.com.pawoonprojecttodolist.screens.landingpage

import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common.views.ObservableViewMvc


interface  MainViewMvc : ObservableViewMvc<MainViewMvc.Listener> {

    interface Listener {
        fun onButtonClicked()
    }


    fun showProgressIndication()

    fun hideProgressIndication()


}