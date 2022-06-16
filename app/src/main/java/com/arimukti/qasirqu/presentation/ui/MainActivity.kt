package com.arimukti.qasirqu.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.arimukti.qasirqu.databinding.ActivityMainBinding
import com.arimukti.qasirqu.presentation.adapter.NewsAdapter
import com.arimukti.qasirqu.presentation.adapter.SavedNewsAdapter
import com.arimukti.qasirqu.presentation.viewmodel.NewsViewModel
import com.arimukti.qasirqu.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: NewsViewModelFactory
    lateinit var viewModel: NewsViewModel

    @Inject
    lateinit var newsAdapter: NewsAdapter

    @Inject
    lateinit var savedNewsAdapter: SavedNewsAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        //val navController = navHostFragment.navController
        //binding.bottomNavigationView.setupWithNavController(navController)
        viewModel = ViewModelProvider(this, factory)[NewsViewModel::class.java]
    }

    //to support navigate up
    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
    }

}