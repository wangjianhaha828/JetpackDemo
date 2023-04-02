package com.wangjian.viewmodel_sample.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.wangjian.viewmodel_sample.R

class RotationScreenActivity : AppCompatActivity() {
    private val viewModel: RotationScreenViewModel  by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotation_screen)

//        viewModel = ViewModelProvider(this).get(RotationScreenViewModel::class.java)
    }
}