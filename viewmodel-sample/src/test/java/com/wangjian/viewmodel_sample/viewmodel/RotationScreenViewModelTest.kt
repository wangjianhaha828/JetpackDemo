package com.wangjian.viewmodel_sample.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import getOrAwaitValue
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert
import org.junit.Rule
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito

internal class RotationScreenViewModelTest{
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var rotationScreenViewModel: RotationScreenViewModel
    private lateinit var myStore: MyStore

    @BeforeEach
    fun setUpViewModel(){
        myStore = MyStore(0)
        rotationScreenViewModel = RotationScreenViewModel(myStore)
    }

    @Test
    fun test_addData(){
        //Given
        // Create observer - no need for it to do anything!
        val observer = Observer<MyStore> {}

        //When
        try {
            // Observe the LiveData forever
            rotationScreenViewModel.numLiveData.observeForever(observer)

            // When adding a new task
            rotationScreenViewModel.addData()

            // Then the new task event is triggered
//            val value = rotationScreenViewModel.numLiveData.value

            val value = rotationScreenViewModel.numLiveData.getOrAwaitValue()
            MatcherAssert.assertThat(value?.num, `is`(1))

        } finally {
            // Whatever happens, don't forget to remove the observer!
//            rotationScreenViewModel?.numLiveData?.removeObserver(observer)
        }

        //Then
//        MatcherAssert.assertThat(myStore.num, `is`(1))
    }
}