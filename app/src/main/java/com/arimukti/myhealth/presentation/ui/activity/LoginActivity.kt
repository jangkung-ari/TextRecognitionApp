package com.arimukti.myhealth.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arimukti.myhealth.data.util.Resource
import com.arimukti.myhealth.databinding.ActivityLoginBinding
import com.arimukti.myhealth.presentation.ui.MainActivity
import com.arimukti.myhealth.presentation.viewmodel.LoginViewModel
import com.arimukti.myhealth.presentation.viewmodel.LoginViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: LoginViewModelFactory

    lateinit var viewModel: LoginViewModel

    private lateinit var binding: ActivityLoginBinding

    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        //val navController = navHostFragment.navController
        //binding.bottomNavigationView.setupWithNavController(navController)
        viewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]
        binding.btnSignIn.setOnClickListener {
            viewModel.login(
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString()
            )
        }
        binding.tvSignUpLabel.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.loginResponse.observe(this, Observer {
            when (it) {
                is Resource.Success -> {
                    hideProgressBar()
                    it.data?.let {
                        Toast.makeText(this, "success login", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
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