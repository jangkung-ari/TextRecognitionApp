package com.arimukti.textrecognitionapp.presentation.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arimukti.textrecognitionapp.databinding.ActivityMainBinding
import com.arimukti.textrecognitionapp.presentation.viewmodel.MainViewModel
import com.arimukti.textrecognitionapp.presentation.viewmodel.MainViewModelFactory
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MainViewModelFactory

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

    private lateinit var textRecognizer: TextRecognizer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        initView()

        textRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

        setupActions()
        setupObserver()
    }

    private fun initView() = with(viewModel) {
        binding.tvInput.text = "Input: ${a.value}"
        binding.tvResult.text = "result: ${c.value}"
    }

    private fun setupObserver() = with(viewModel) {
        c.observe(this@MainActivity, Observer {
            initView()
        })
        a.observe(this@MainActivity, Observer {
            initView()
        })
    }

    private fun setupActions() = with(binding) {
        btnInput.setOnClickListener {
            ImagePicker.with(this@MainActivity)
                .crop()
//                .galleryOnly()
//                .cameraOnly()
                .compress(1024)
                .maxResultSize(1080, 1080)
                .start()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            val uri = data?.data
            recognizeText(uri)
        }
    }

    private fun recognizeText(uri: Uri?) {
        uri?.let {
            val inputImage: InputImage = InputImage.fromFilePath(this, uri)
            val result: Task<Text> = textRecognizer.process(inputImage)
                .addOnSuccessListener(OnSuccessListener {
                    val recognizeText = it.text
                    viewModel.calculate(recognizeText)
                })
                .addOnFailureListener(OnFailureListener {
                    val exception = it.message
                })
        }
    }
}