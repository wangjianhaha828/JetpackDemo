package com.wangjian.viewmodel_sample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RotationScreenViewModel(
//    private val myStore: MyStore,
//    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val myStore: MyStore = MyStore(0)

    val numLiveData = MutableLiveData<MyStore>()

    fun addData() {
        myStore.num++
        numLiveData.value = myStore
    }


}