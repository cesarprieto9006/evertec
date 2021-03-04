package com.example.evertec.screens.splash.viewmodel

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import utils.SuperAppConstants


class SplashViewModel :ViewModel() {

    private val _stateSplash = MutableLiveData<Boolean>(false)
    val stateSplash: LiveData<Boolean> get() = _stateSplash

    fun timerSplash() {

        Handler().postDelayed({
            _stateSplash.value=true
        }, SuperAppConstants.TIME_SPLASH_SETUP)
    }

}