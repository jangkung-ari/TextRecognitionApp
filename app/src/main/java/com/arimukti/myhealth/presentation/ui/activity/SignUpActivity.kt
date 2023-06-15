package com.arimukti.myhealth.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arimukti.myhealth.data.util.Resource
import com.arimukti.myhealth.databinding.ActivitySignUpBinding
import com.arimukti.myhealth.presentation.viewmodel.SignUpViewModel
import com.arimukti.myhealth.presentation.viewmodel.SignUpViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: SignUpViewModelFactory

    lateinit var viewModel: SignUpViewModel

    private lateinit var binding: ActivitySignUpBinding

    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, factory)[SignUpViewModel::class.java]
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignUp.setOnClickListener {
            viewModel.signUp(
                username = binding.etName1.text.toString(),
                email = binding.etEmail.text.toString(),
                password = binding.etPassword.text.toString()
            )
        }
        binding.tvSignInLabel.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.tvSignUpLabel.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.signUpResponse.observe(this, Observer {
            when (it) {
                is Resource.Success -> {
                    hideProgressBar()
                    it.data?.let {
                        Toast.makeText(this, "register success", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    it.message?.let { error ->
                        Toast.makeText(this, "An error occured : $error", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }


    private fun showProgressBar() = with(binding.pbLoading) {
        isLoading = true
        visibility = View.VISIBLE
    }

    private fun hideProgressBar() = with(binding.pbLoading) {
        isLoading = false
        visibility = View.INVISIBLE
    }
}