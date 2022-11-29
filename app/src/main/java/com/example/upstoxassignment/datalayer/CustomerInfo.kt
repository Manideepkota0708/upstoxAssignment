package com.example.upstoxassignment.datalayer

data class CustomerInfo(
    val client_id: String,
    val data: List<StockInfo>,
    val error: String,
    val response_type: String,
    val timestamp: String
)