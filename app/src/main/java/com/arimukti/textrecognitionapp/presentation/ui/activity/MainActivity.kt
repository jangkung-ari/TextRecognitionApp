package com.arimukti.textrecognitionapp.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arimukti.textrecognitionapp.databinding.ActivityMainBinding
import com.arimukti.textrecognitionapp.presentation.viewmodel.MainViewModel
import com.arimukti.textrecognitionapp.presentation.viewmodel.MainViewModelFactory
import com.github.dhaval2404.imagepicker.ImagePicker
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MainViewModelFactory

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        initView()
        setupActions()
        setupObserver()
    }

    private fun initView() = with(viewModel) {
        binding.tvInput.text = "Input: ${a.value} + ${b.value}"
        binding.tvResult.text = "result: ${c.value}"
    }

    private fun setupObserver() = with(viewModel) {
        a.observe(this@MainActivity, Observer {

        })
    }

    private fun setupActions() = with(binding) {
        btnInput.setOnClickListener {
            ImagePicker.with(this@MainActivity)
                .crop()
                .compress(1024)
                .maxResultSize(1080, 1080)
                .start()
        }
    }
}