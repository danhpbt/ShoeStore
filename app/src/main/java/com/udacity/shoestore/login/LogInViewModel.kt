package com.udacity.shoestore.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LogInViewModel : ViewModel() {

    val email = MutableLiveData<String>().apply {
        value = ""
    }

    val password = MutableLiveData<String>().apply {
        value = ""
    }

}