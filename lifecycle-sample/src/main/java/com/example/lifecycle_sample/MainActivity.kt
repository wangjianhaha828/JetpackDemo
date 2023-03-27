package com.example.lifecycle_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class MainActivity : AppCompatActivity(), LifecycleOwner {

//    private lateinit var lifecycleRegistry: LifecycleRegistry
    private lateinit var myLocationListener: MyLocationListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        lifecycleRegistry = LifecycleRegistry(this)
//        lifecycleRegistry.currentState = Lifecycle.State.CREATED

        myLocationListener = MyLocationListener(this,lifecycle){
            Log.d("TAG",it)
        }
        lifecycle.addObserver(myLocationListener)
    }

    override fun onStart() {
        super.onStart()
//        lifecycleRegistry.currentState = Lifecycle.State.STARTED
        myLocationListener.enable()
    }

//    override fun getLifecycle(): Lifecycle {
//        return lifecycleRegistry
//    }
}