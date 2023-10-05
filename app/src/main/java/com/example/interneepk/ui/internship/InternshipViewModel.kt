package com.example.interneepk.ui.internship

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InternshipViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is internship Fragment"
    }
    val text: LiveData<String> = _text
}