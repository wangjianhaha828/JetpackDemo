package com.example.lifecycle_sample

import android.content.Context
import android.location.Location
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

internal class MyLocationListener(
    private val context: Context,
    private val lifecycle: Lifecycle,
    private val callback: (String) -> Unit
):DefaultLifecycleObserver {

    private var enabled = false

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        if (enabled){
            // connect
            Log.d("TAG","开始定位-onStart")
            callback.invoke("定位成功-北京")
        }
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d("TAG","onStop()")
    }

    fun enable(){
        enabled = true
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            // connect if not connected
            Log.d("TAG","开始定位-enable")
        }
    }

}