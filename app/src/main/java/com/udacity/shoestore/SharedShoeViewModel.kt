package com.udacity.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedShoeViewModel : ViewModel() {
    val shoe = MutableLiveData<Shoe>()

    fun setShoe(shoeVal : Shoe) {
        shoe.value = shoeVal
    }
}