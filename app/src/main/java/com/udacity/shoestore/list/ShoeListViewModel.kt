package com.udacity.shoestore.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val mShoeList = MutableLiveData<List<Shoe>>()

    val shoeList : LiveData<List<Shoe>>
        get() = mShoeList


}