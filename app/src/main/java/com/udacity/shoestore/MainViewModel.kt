package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewModel : ViewModel() {
    private val mShoeList = ArrayList<Shoe>()
    private val mShoeListLiveData = MutableLiveData<MutableList<Shoe>>()

    init {
        mShoeListLiveData.value = mShoeList
    }

    var shoeListLiveData: LiveData<MutableList<Shoe>> = mShoeListLiveData
        get() = mShoeListLiveData

    fun addShoe(shoe : Shoe)
    {
        mShoeList.add(shoe)
        mShoeListLiveData.value = mShoeList
    }
}