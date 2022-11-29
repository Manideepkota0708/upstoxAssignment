package com.example.upstoxassignment.datalayer.uilayer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.upstoxassignment.R
import com.example.upstoxassignment.datalayer.StockInfo

class StockListingAdapter(
    private val context: Context,
    private val stockInfoList: List<StockInfo>
) : RecyclerView.Adapter<StockListingAdapter.StockInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return StockInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: StockInfoViewHolder, position: Int) {
        holder.symbolView.text = stockInfoList[position].symbol
        holder.quantityView.text = stockInfoList[position].quantity.toString()
        holder.lTPView.text = context.getString(R.string.ltpFormat, stockInfoList[position].ltp)
        holder.pNLView.text = stockInfoList[position].run {
            context.getString(R.string.plFormat, (ltp*quantity - avg_price*quantity))
        }
    }

    override fun getItemCount() = stockInfoList.size


    class StockInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val symbolView: TextView = itemView.findViewById(R.id.tv_symbol)
        val quantityView: TextView = itemView.findViewById(R.id.tv_quantity)
        val lTPView: TextView = itemView.findViewById(R.id.tv_lTP)
        val pNLView: TextView = itemView.findViewById(R.id.tv_pNL)

    }
}
