package com.udacity.shoestore.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel : ViewModel() {
    private val mShoe = MutableLiveData<String>()
    var shoe: LiveData<String> = mShoe
        get() = mShoe

    private val mCompany = MutableLiveData<String>()
    var company: LiveData<String> = mCompany
        get() = mCompany

    private val mSize = MutableLiveData<Double>()
    var size: LiveData<Double> = mSize
        get() = mSize

    private val mDescription = MutableLiveData<String>()
    var description: LiveData<String> = mDescription
        get() = mDescription
}