package com.github.aicoleman.digimonrxsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.transition.TransitionManager
import com.github.aicoleman.digimonrxsample.R
import com.github.aicoleman.digimonrxsample.databinding.ActivityMainBinding
import com.google.android.material.transition.MaterialSharedAxis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true).apply {
        duration = 500
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        TransitionManager.beginDelayedTransition(findViewById(android.R.id.content), enterTransition)
    }
}