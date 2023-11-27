package com.ta.metalworking.ui.keyway

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KeywayDimensionsViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is kay way Fragment"
    }
    val text: LiveData<String> = _text
}