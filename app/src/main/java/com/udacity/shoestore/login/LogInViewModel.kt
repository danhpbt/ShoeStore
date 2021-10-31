package com.udacity.shoestore.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LogInViewModel : ViewModel() {
    private val mEmail = MutableLiveData<String>()
    var email: LiveData<String> = mEmail
        get() = mEmail

    private val mPassword = MutableLiveData<String>()
    var password: LiveData<String> = mPassword
        get() = mPassword

}