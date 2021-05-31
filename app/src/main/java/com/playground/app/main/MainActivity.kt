package com.playground.app.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.playground.app.PlaygroundApp
import com.playground.app.common.util.createViewModel
import com.playground.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val repository = (application as PlaygroundApp).repository
        viewModel = createViewModel { MainViewModel(it, repository) }
        viewModel.stateLiveData.observe(this, { render(it) })
    }

    private fun render(state: MainViewModel.State) {
    }
}
