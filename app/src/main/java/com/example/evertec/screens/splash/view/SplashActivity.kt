package com.example.evertec.screens.splash.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.evertec.R
import com.example.evertec.databinding.ActivitySplashBinding
import com.example.evertec.screens.main.view.PayActivity

import com.example.evertec.screens.splash.viewmodel.SplashViewModel


class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModels()
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this, R.layout.activity_splash)
        viewModel.timerSplash()

        startLoading(this)
        observeLiveData()
    }

    private fun startLoading(context: Context?) {
        val loadingRotationAnim: Animation = AnimationUtils.loadAnimation(
            context, R.anim.rotation_360)
        binding.ivLogo.startAnimation(loadingRotationAnim)
    }

    private fun observeLiveData(){
        viewModel.stateSplash.observe(this, Observer { state->
            if(state){
                startActivity(Intent(this, PayActivity::class.java))
            }
        })
    }
}