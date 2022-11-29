package com.example.upstoxassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.upstoxassignment.databinding.ActivityMainBinding
import com.example.upstoxassignment.datalayer.uilayer.StockListingAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel by viewModels<MainActivityViewModel>()
    private lateinit var activityMainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        bindFlows()
    }

    private fun bindFlows() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainActivityViewModel.homePageStateFlow.collectLatest {
                    activityMainBinding.rvStocksHoldings.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = StockListingAdapter(this@MainActivity, it.stockInfoList)
                    }

                    activityMainBinding.tvCurrentValueValue.text = applicationContext.getString(R.string.rupeeFormat, it.currentValue())
                    activityMainBinding.tvTotalInvestmentValue.text = applicationContext.getString(R.string.rupeeFormat, it.totalInvestment())
                    activityMainBinding.tvTodaysPNLValue.text = applicationContext.getString(R.string.rupeeFormat, it.toDaysProfitAndLoss())
                    activityMainBinding.tvPNLValue.text = applicationContext.getString(R.string.rupeeFormat, it.totalProfitAndLoss())

                }
            }
        }

    }
}