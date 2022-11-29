package com.example.upstoxassignment.datalayer.uilayer

import com.example.upstoxassignment.datalayer.StockInfo

data class HomePage(
    val stockInfoList: List<StockInfo> = listOf()
) {
    fun currentValue() = stockInfoList.map { it.quantity * it.ltp }.sum()

    fun totalInvestment() = stockInfoList.map { it.avg_price * it.quantity }.sum()

    fun totalProfitAndLoss() = currentValue() - totalInvestment()

    fun toDaysProfitAndLoss() = stockInfoList.map { (it.close - it.ltp) * it.quantity }.sum()
}