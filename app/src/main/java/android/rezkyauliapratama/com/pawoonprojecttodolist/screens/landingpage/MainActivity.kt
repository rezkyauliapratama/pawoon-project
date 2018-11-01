package android.rezkyauliapratama.com.pawoonprojecttodolist.screens.landingpage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.rezkyauliapratama.com.pawoonprojecttodolist.R
import android.rezkyauliapratama.com.pawoonprojecttodolist.databinding.ActivityMainBinding
import android.rezkyauliapratama.com.pawoonprojecttodolist.screens.common.controller.BaseActivity

class MainActivity : BaseActivity<MainController, MainViewMvc, ActivityMainBinding>() {

    override fun initDataBinding() {
        mDataBinding = mViewMvc.dataBinding as ActivityMainBinding
    }

    override fun initView() {
        mViewMvc = viewMvcFactory.getMainViewMvc(null)
        mController.bindView(mViewMvc)
    }

    override fun inject() {
        controllerComponent.inject(this)
    }

    override fun onStart() {
        super.onStart()
        mController.onStart()
    }

    override fun onStop() {
        super.onStop()
        mController.onStop()
    }

}
