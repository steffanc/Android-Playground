package com.playground.app.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.playground.app.PlaygroundApp
import com.playground.app.common.util.createViewModel
import com.playground.app.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        val repository = (application as PlaygroundApp).repository
        viewModel = createViewModel { DetailViewModel(it, repository) }
        viewModel.stateLiveData.observe(this, { render(it) })
    }

    private fun render(state: DetailViewModel.State) {
    }
}
