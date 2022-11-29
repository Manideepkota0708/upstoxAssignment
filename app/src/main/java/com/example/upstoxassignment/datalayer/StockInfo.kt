package com.example.upstoxassignment.datalayer

data class StockInfo(
    val avg_price: Float,
    val cnc_used_quantity: Int,
    val collateral_qty: Int,
    val collateral_type: String,
    val collateral_update_qty: Int,
    val company_name: String,
    val haircut: Float,
    val holdings_update_qty: Int,
    val isin: String,
    val product: String,
    val quantity: Int,
    val symbol: String,
    val t1_holding_qty: Int,
    val token_bse: String,
    val token_nse: String,
    val withheld_collateral_qty: Int,
    val withheld_holding_qty: Int,
    val ltp: Float,
    val close : Float
)
