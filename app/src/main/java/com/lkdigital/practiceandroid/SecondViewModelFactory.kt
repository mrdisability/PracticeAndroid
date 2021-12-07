package com.lkdigital.practiceandroid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SecondViewModelFactory(var passedClicks: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SecondViewModel::class.java)) {
            //If we can create it we can create the viewModel with the correct parameter
            return SecondViewModel(passedClicks) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}