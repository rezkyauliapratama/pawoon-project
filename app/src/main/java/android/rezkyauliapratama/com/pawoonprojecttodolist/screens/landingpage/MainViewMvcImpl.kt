package android.rezkyauliapratama.com.pawoonprojecttodolist.screens.landingpage

import android.databinding.DataBindingUtil
import android.rezkyauliapratama.com.pawoonprojecttodolist.R
import android.rezkyauliapratama.com.pawoonprojecttodolist.databinding.ActivityMainBinding
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common.ViewMvcFactory
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common.views.BaseObservableViewMvc
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.sdk25.coroutines.onClick


class MainViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?, viewMvcFactory: ViewMvcFactory) :
    BaseObservableViewMvc<MainViewMvc.Listener>(), MainViewMvc {

    var binding : ActivityMainBinding = DataBindingUtil.inflate(inflater, R.layout.activity_main,parent,false)

    init{
        dataBinding = binding
        binding.button.visibility = View.GONE

        binding.button.onClick {
            for(listener in listeners){
                listener.onButtonClicked()
            }
        }

    }

    override fun showProgressIndication() {
        binding.button.visibility = View.GONE
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressIndication() {
        binding.button.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE

    }


}