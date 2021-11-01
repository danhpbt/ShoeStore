package com.udacity.shoestore.detail

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailViewModel : ViewModel() {
    private val mShoe = MutableLiveData<Shoe>(Shoe("", 0.0, "", ""))
    var shoe: LiveData<Shoe> = mShoe
        get() = mShoe

}