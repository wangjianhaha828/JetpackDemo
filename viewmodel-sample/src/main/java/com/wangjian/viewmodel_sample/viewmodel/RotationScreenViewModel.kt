package com.wangjian.viewmodel_sample.viewmodel

import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

class RotationScreenViewModel(
    private val myStore: MyStore,
) : ViewModel() {

//    private val myStore: MyStore = MyStore(0)

    val numLiveData = MutableLiveData<MyStore>()

    fun addData() {
        myStore.num++
        numLiveData.value = myStore
    }

    companion object {

        //如果 ViewModel 有依赖，需要自定义 Factory ，以下两种 Factory 写法都可以
        val Factory1: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Create a SavedStateHandle for this ViewModel from extras
                val savedStateHandle = extras.createSavedStateHandle()
                return RotationScreenViewModel(
                    MyStore(0),
                ) as T
            }
        }

        val Factory2: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val savedStateHandle = createSavedStateHandle()
                RotationScreenViewModel(
                    MyStore(0),
                )
            }
        }
    }


}