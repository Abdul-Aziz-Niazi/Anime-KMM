package com.abdulaziz.animekmm.android.domain

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FeedViewModel : ViewModel() {
    var showLoader = MutableLiveData<Boolean>()


}