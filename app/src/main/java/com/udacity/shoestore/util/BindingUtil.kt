package com.udacity.shoestore.util

import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter


///////////////////////////////////////
//https://medium.com/@ssiasoft/two-way-data-binding-and-managing-text-inputs-in-android-9cc4701f628e
///////////////////////////////////////
@BindingAdapter("android:text")
fun EditText.bindObjectInText(value: Any?) {
    value?.let {
        if (value!=tag) { // Store the original value
            tag = value   // To prevent duplicate/extra modification

            if (value is Double) {
                setText(String.format("%.0f", value))
            }
            else
                setText(value.toString())
        }
    }
}

@InverseBindingAdapter(attribute = "android:text")
fun EditText.getDoubleFromBinding(): Double? {
    val result=text.toString()

    return try {
        result.toDouble()
    }catch (e:Exception){
        0.0
    }
}