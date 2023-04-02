package com.wangjian.viewmodel_sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wangjian.viewmodel_sample.databinding.ActivityMainBinding
import com.wangjian.viewmodel_sample.viewmodel.RotationScreenActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnViewModel.setOnClickListener{
            startActivity(Intent(this,RotationScreenActivity::class.java))
        }
    }
}