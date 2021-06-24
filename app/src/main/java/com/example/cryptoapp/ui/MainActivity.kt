package com.example.cryptoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.network.response.get.CryptoResponse
import com.example.cryptoapp.ui.adapters.CryptoRecyclerAdapter
import com.example.cryptoapp.utils.Status
import com.example.cryptoapp.viewModel.CryptoViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this).get(CryptoViewModel::class.java)
    }
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getMarketValue()
        viewModel.cryptoList.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    val res = it.data
                    res?.let {
                        stopShimmer()
                        setUpAdapter(res)
                    }
                }
                Status.ERROR -> {

                }
                Status.LOADING -> {

                }
                else -> {

                }

            }

        })
    }

    override fun onResume() {
        super.onResume()
        binding.shimmerLayout.startShimmer()
    }

    override fun onPause() {
        super.onPause()
        binding.shimmerLayout.stopShimmer()
    }

    private fun stopShimmer() {
        binding.shimmerLayout.stopShimmer()
        binding.shimmerLayout.visibility = View.GONE
    }

    private fun setUpAdapter(res: CryptoResponse) {
        binding.marketRev.visibility = View.VISIBLE
        binding.marketRev.adapter = CryptoRecyclerAdapter(res.markets)
        binding.marketRev.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}