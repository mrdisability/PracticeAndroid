package com.lkdigital.practiceandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel: ViewModel() {
    //ViewModel does not have a lifecycle, it bounds to its owner
    //Exists until fragment is destroyed

//    var message = ""
//    var clicks = 0

    //Mutable LiveData
    //Can be changed
    //Create live data in viewModel then create observers in fragment
    //Observables
//    val message = MutableLiveData<String>()
//    val clicks = MutableLiveData<Int>()

    //Only exist in viewModel so we can change it
    private val _message = MutableLiveData<String>()

    //LiveData so can read it but cant change it
    val message: LiveData<String> get() = _message

    private val _clicks = MutableLiveData<Int>()

    //Only exposing LiveData to other classes
    val clicks: LiveData<Int> get() = _clicks

    //LiveData can be read but not changed
    //We dont want other classes or fragments changing these values

    init {
        //When viewModel is created with fragment
        //When initializing then change value of mutable live data
        _message.value = ""
        _clicks.value = 0
    }

    fun hello(name: String) {
        _message.value = "Hello $name"
        _clicks.value = clicks.value?.plus(1)
    }

    fun goodbye(name: String) {
        _message.value = "Goodbye $name"
        //Return value if exist if not then null
        _clicks.value = clicks.value?.plus(1)
    }
}