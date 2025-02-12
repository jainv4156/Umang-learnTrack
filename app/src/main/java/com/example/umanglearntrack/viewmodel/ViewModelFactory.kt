package com.example.umanglearntrack.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(val context:Context):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
         if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
             return HomeViewModel(context) as T
         }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}